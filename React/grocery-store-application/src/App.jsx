import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import MyHeader from "./Components/MyHeader";
import ProductList from "./Components/ProductList";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Cart from "./Components/Cart";
import Orders from "./Components/Orders";
import Footer from "./Components/Footer";



const App = () => {
  return (
    <>
     <BrowserRouter>
      <MyHeader/>
      <Routes>
        <Route path="/" element={<ProductList/>}></Route>
        <Route path="/orders" element={<Orders/>}></Route>
        <Route path="/cart" element={<Cart/>}></Route>
        <Route path="/contact" element={<Footer/>}></Route>
        
      </Routes>
     </BrowserRouter>
    </>
  );
};

export default App;
