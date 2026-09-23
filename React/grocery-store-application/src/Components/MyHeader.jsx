import React from "react";
import { Navbar, Container, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";
import logo from "../assets/logo3.png";
import "../Components/MyHeader.css";

const MyHeader = () => {
  return (
    <Navbar
      expand="lg"
      className="shadow-sm py-2"
      style={{ backgroundColor: "#198754" }} // Fresh green theme 🌱
      variant="dark"
    >
      <Container>
        {/* LOGO + BRAND */}
        <Navbar.Brand
          as={Link}
          to="/"
          className="d-flex align-items-center gap-2"
        >
          <img
            src={logo}
            alt="FreshMart"
            width="80"
            height="80"
            className="rounded-circle"
          />
          <span className="fw-bold fs-4">FreshMart</span>
        </Navbar.Brand>

        {/* MOBILE TOGGLE */}
        <Navbar.Toggle aria-controls="basic-navbar-nav" />

        <Navbar.Collapse id="basic-navbar-nav">
          {/* NAV LINKS */}
          <Nav className="ms-auto align-items-center gap-3">
            <Nav.Link as={Link} to="/" className="nav-link-custom">
              Home
            </Nav.Link>

            <Nav.Link as={Link} to="/orders" className="nav-link-custom">
              Orders
            </Nav.Link>

            <Nav.Link as={Link} to="/cart" className="nav-link-custom">
              Cart 🛒
            </Nav.Link>

            <Nav.Link as={Link} to="/contact" className="nav-link-custom">
              Contact
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default MyHeader;
