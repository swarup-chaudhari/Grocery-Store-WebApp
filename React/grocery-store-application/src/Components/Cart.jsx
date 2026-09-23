import React, { useEffect, useState } from "react";
import { Button, Card } from "react-bootstrap";

const Cart = () => {
  const [cart, setCart] = useState([]);
  const email = "test@gmail.com";

  const fetchCart = () => {
    fetch(`http://localhost:8080/cart/${email}`)
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
        setCart(data);
      })
      .catch((err) => console.error(err));
  };

  const placeOrder = () => {
    const orderData = {
      email: "test@gmail.com",
      address: "Pune",
      phoneNumber: "1234567890",
      paymentMethod: "COD",
    };

    
    fetch("http://localhost:8080/orders/place", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body:JSON.stringify(orderData),
    })
      .then((res) => res.json())
      .then(() => {
        alert("Order Placed ✅");
        fetchCart();
      });
  };

  useEffect(() => {
    fetchCart();
  }, []);

  const total = cart.reduce((sum, item) => {
    return sum + item.price * item.quantity;
  }, 0);

  const removeItem = (id) => {
    fetch(`http://localhost:8080/cart/items/${id}`, {
      method: "DELETE",
    }).then(() => {
      alert("Item Removed ❌");
      fetchCart();
    });
  };

  return (
    <>
      <div className="container mt-5">
        <h2 className="text-center fw-bold mb-3">Your Cart 🛒</h2>
        {cart.length === 0 ? (
          <h4 className="text-muted text-center">No Items</h4>
        ) : (
          <>
            <div className="row">
              {cart.map((item) => (
                <div className="col-md-4 col-sm-6 mb-3" key={item.id}>
                  <Card className="shadow-sm rounded border-0 p-3 text-center">
                    <img
                      src={item.imageUrl}
                      alt={item.foodName}
                      style={{ height: "150px", objectFit: "cover" }}
                      className="rounded img-fluid "
                    />
                    <h5 className="fw-bolder mt-2">{item.foodName}</h5>
                    <p className="text-muted fw-bold fs-5">
                      Price : {item.price}
                    </p>
                    <p className="text-success fw-bold fs-5">
                      Quantity : {item.quantity}
                    </p>
                    <div className="d-flex justify-content-center align-items-center">
                      <Button
                        variant="outline-danger w-50"
                        onClick={() => removeItem(item.id)}
                      >
                        Remove
                      </Button>
                    </div>
                  </Card>
                </div>
              ))}
            </div>
          </>
        )}
      </div>
      <div className="mt-4 text-center">
        <h3>Total : ${total}</h3>
        <Button variant="primary" onClick={placeOrder}>
          Order Now
        </Button>
      </div>
    </>
  );
};

export default Cart;
