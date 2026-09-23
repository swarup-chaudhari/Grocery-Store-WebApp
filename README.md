# Grocery Store Web App 🛒🥦

A full-stack **Grocery Store Web Application** built using **React.js, Spring Boot, and MySQL**. The application allows users to browse grocery products, explore categories, add items to the cart, and place orders.

## 🚀 Technologies Used

### Frontend

* React.js
* React Bootstrap
* React Router
* JavaScript
* HTML5
* CSS3
* Axios / Fetch API

### Backend

* Java
* Spring Boot
* Spring Data JPA
* REST APIs

### Database

* MySQL

## ✨ Features

* 🛒 Browse grocery products
* 📂 Browse products by category
* 🔍 View product details
* ➕ Add products to cart
* 🛍️ Manage cart items
* 📦 Place orders
* 📋 View orders
* 🔗 REST API integration
* 📱 Responsive user interface

## 📂 Project Structure

```text
Grocery-Store/
│
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── Styles/
│   │   ├── App.js
│   │   └── index.js
│   └── package.json
│
└── backend/
    ├── src/
    │   └── main/
    │       ├── java/
    │       └── resources/
    └── pom.xml
```

## ⚙️ Setup & Installation

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/Grocery-Store.git
```

### 2. Backend Setup

Open the backend project in **Spring Tool Suite (STS)** or **Eclipse**.

Configure the MySQL database in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/grocery_store
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Start the Spring Boot application.

The backend will run on:

```text
http://localhost:8080
```

### 3. Frontend Setup

Open the frontend folder in **VS Code**.

Install the required dependencies:

```bash
npm install
```

Start the React application:

```bash
npm start
```

If the project uses Vite, use:

```bash
npm run dev
```

The frontend will normally run on:

```text
http://localhost:3000
```

or, for Vite:

```text
http://localhost:5173
```

## 🔗 Application Architecture

```text
        React.js Frontend
                │
                │ REST API
                ↓
       Spring Boot Backend
                │
                │ JPA / Hibernate
                ↓
          MySQL Database
```

## 🛍️ Main Functionalities

### 🥬 Products

Users can browse available grocery products and view their details such as name, price, category, and availability.

### 📂 Categories

Products can be organized into different grocery categories to make browsing easier.

### 🛒 Cart

Users can add products to the shopping cart and manage the selected items before placing an order.

### 📦 Orders

Users can place orders for products added to their cart and view their order information.

## 📌 Future Enhancements

* User registration and login
* Product search and filtering
* Wishlist
* Online payment integration
* Order tracking
* Admin dashboard
* Product reviews and ratings
* Stock management
* User profile management

## 👨‍💻 Author

**Swarup Chaudhari**

GitHub: [github.com/swarup-chaudhari](https://github.com/swarup-chaudhari)

## 📄 License

This project is created for **learning and educational purposes**.
