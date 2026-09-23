import React, { useEffect, useState } from "react";
import { Button, Card } from "react-bootstrap";
import "../Components/ProductList.css";

const addToCart = (item) => {
  const cartItem = {
    userEmail: "test@gmail.com",
    foodId: item.id,
    foodName: item.name,
    price: item.price,
    quantity: 1,
    imageUrl: item.imageUrl,
  };

  fetch("http://localhost:8080/cart/add", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(cartItem),
  })
    .then((res) => res.json())
    .then(() => alert("Added To Cart ✅"))
    .catch((err) => console.error(err));
};

const ProductList = () => {
  const [products, setProducts] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState("All");

  useEffect(() => {
    fetch("http://localhost:8080/products")
      .then((res) => res.json())
      .then((data) => setProducts(data))
      .catch((err) => console.error(err));
  }, []);

  const categories = ["All", ...new Set(products.map((p) => p.category))];

  const filteredProducts =
    selectedCategory === "All"
      ? products
      : products.filter((p) => p.category === selectedCategory);

  return (
    <div className="container-fluid mt-4">
      <div className="row">
        {/* 🔥 SIDEBAR */}
        <div className="col-lg-3 mb-4">
          <div className="category-card shadow-sm p-3 rounded-4">
            <h5 className="fw-bold mb-3">Categories</h5>
            <div className="list-group">
              {categories.map((cat, index) => (
                <button
                  key={index}
                  className={`list-group-item list-group-item-action category-btn ${
                    selectedCategory === cat ? "active-category" : ""
                  }`}
                  onClick={() => setSelectedCategory(cat)}
                >
                  {cat}
                </button>
              ))}
            </div>
          </div>
        </div>

        {/* 🔥 PRODUCTS */}
        <div className="col-lg-9">
          <div className="row g-4">
            {filteredProducts.map((p) => (
              <div className="col-md-6 col-lg-4" key={p.id}>
                <Card className="product-card border-0 shadow-sm h-100">
                  {/* IMAGE */}
                  <div className="product-img-wrapper">
                    <Card.Img src={p.imageUrl} className="product-img" />
                  </div>

                  {/* BODY */}
                  <Card.Body className="text-center">
                    <h5 className="fw-bold">{p.name}</h5>
                    <p className="text-success fw-bold fs-5">₹{p.price}</p>
                  </Card.Body>

                  {/* BUTTONS */}
                  <div className="d-flex justify-content-center gap-2 mb-3 px-2">
                    <Button variant="outline-success" className="w-50">
                      Buy
                    </Button>
                    <Button
                      variant="success"
                      className="w-50"
                      onClick={() => addToCart(p)}
                    >
                      Add
                    </Button>
                  </div>
                </Card>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProductList;
