import React, { useEffect, useState } from "react";
import { Button, Card } from "react-bootstrap";

const Orders = () => {
  const [items, setItems] = useState([]);
  const email = "test@gmail.com";

  const fetchOrders = () => {
    fetch(`http://localhost:8080/orders/${email}`)
      .then((res) => res.json())
      .then((data) => {
        console.log("ORDER DATA:", data);

        const allItems = data.flatMap((o) =>
          (o.orderitems || []).map((item) => ({
            ...item,
            orderId: o.id,
            status: o.status,
          })),
        );

        setItems(allItems);
      })
      .catch((err) => console.error(err));
  };

  useEffect(() => {
    fetchOrders();
  }, []);

  const cancelOrder = (id) => {
    fetch(`http://localhost:8080/orders/cancel/${id}`, {
      method: "PUT",
    })
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
        alert("Order Cancelled ❌");
        fetchOrders();
      })
      .catch((err) => console.error(err));
  };

  return (
    <div className="container mt-5">
      <h2 className="text-center fw-bold mb-4">Your Orders 📦</h2>

      {items.length === 0 ? (
        <h4 className="text-center text-muted">No Items Found</h4>
      ) : (
        <div className="row">
          {items.map((item) => (
            <div className="col-md-4 col-sm-6 mb-3" key={item.id}>
              <Card className="shadow-sm border-0 rounded text-center h-100 p-3">
                <img
                  src={item.imageUrl || "https://via.placeholder.com/150"}
                  alt={item.foodName}
                  style={{
                    height: "150px",
                    objectFit: "cover",
                  }}
                  className="rounded img-fluid"
                />

                <h5 className="fw-bold mt-2">{item.foodName}</h5>

                <p className="text-muted fw-bold">Price: ₹{item.price}</p>

                <p className="text-primary fw-bold">
                  Quantity: {item.quantity}
                </p>

                <p
                  className={
                    item.status === "CANCELLED"
                      ? "text-danger fw-bold"
                      : "text-success fw-bold"
                  }
                >
                  Status: {item.status}
                </p>

                <div className="d-flex justify-content-center align-item-center mb-3">
                  <Button
                    variant="outline-danger"
                    onClick={() => cancelOrder(item.orderId)}
                  >
                    Cancel Order
                  </Button>
                </div>
              </Card>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default Orders;
