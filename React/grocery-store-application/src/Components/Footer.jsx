import React from "react";
import { Button, Card, Form } from "react-bootstrap";
import { Send, Phone, Envelope, GeoAlt } from "react-bootstrap-icons";

const Footer = () => {
  return (
    <>
      {/* HEADER */}
      <div className="container mt-5">
        <div className="text-center mb-4">
          <h2 className="fw-bold display-6">Contact FreshMart 🛒</h2>
          <p className="text-muted">
            Have questions or feedback? We’d love to hear from you.
          </p>
        </div>

        <div className="row g-4">
          {/* CONTACT FORM */}
          <div className="col-md-6">
            <Card className="shadow-sm border-0 rounded-4 p-4 h-100">
              <h5 className="fw-bold mb-3">Send Us a Message</h5>

              <Form>
                <Form.Control
                  type="text"
                  placeholder="Your Name"
                  className="mb-3"
                />

                <Form.Control
                  type="email"
                  placeholder="Your Email"
                  className="mb-3"
                />

                <Form.Control
                  type="text"
                  placeholder="Subject"
                  className="mb-3"
                />

                <Form.Control
                  as="textarea"
                  rows={4}
                  placeholder="Your Message"
                  className="mb-3"
                />

                <Button variant="success" className="w-100">
                  <Send className="me-2" />
                  Send Message
                </Button>
              </Form>
            </Card>
          </div>

          {/* CONTACT INFO */}
          <div className="col-md-6">
            <Card className="shadow-sm border-0 rounded-4 p-4 h-100">
              <h5 className="fw-bold mb-3">Get In Touch</h5>

              <div className="d-flex align-items-center mb-3">
                <Phone size={20} className="me-3 text-success" />
                <span className="text-muted">+91 9322245900</span>
              </div>

              <div className="d-flex align-items-center mb-3">
                <Envelope size={20} className="me-3 text-success" />
                <span className="text-muted">support@freshmart.com</span>
              </div>

              <div className="d-flex align-items-start">
                <GeoAlt size={20} className="me-3 text-success mt-1" />
                <span className="text-muted">
                  123 Grocery Street <br />
                  Pune, Maharashtra, India
                </span>
              </div>
            </Card>
          </div>
        </div>
      </div>

      {/* FEATURES SECTION */}
      <div className="container mt-5 mb-4">
        <div className="row g-4">
          {[
            {
              img: "https://cdn-icons-png.flaticon.com/128/2203/2203124.png",
              title: "Fast Delivery",
              desc: "On time, every time",
            },
            {
              img: "https://cdn-icons-png.flaticon.com/128/3712/3712214.png",
              title: "Best Quality",
              desc: "Fresh & organic groceries",
            },
            {
              img: "https://cdn-icons-png.flaticon.com/128/726/726488.png",
              title: "Secure Payment",
              desc: "100% safe & secure",
            },
            {
              img: "https://cdn-icons-png.flaticon.com/128/5729/5729090.png",
              title: "24/7 Support",
              desc: "We’re always here to help",
            },
          ].map((feature, index) => (
            <div className="col-md-3 col-sm-6" key={index}>
              <Card className="text-center shadow-sm border-0 rounded-4 p-3 h-100">
                <img
                  src={feature.img}
                  alt={feature.title}
                  style={{ width: "60px" }}
                  className="mx-auto mb-3"
                />
                <h6 className="fw-bold">{feature.title}</h6>
                <p className="text-muted small">{feature.desc}</p>
              </Card>
            </div>
          ))}
        </div>
      </div>
    </>
  );
};

export default Footer;
