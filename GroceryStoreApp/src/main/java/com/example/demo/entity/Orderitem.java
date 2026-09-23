package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orderitem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String foodName;

	int quantity;

	double price;

	String imageUrl;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "order_id")
	Order order;

	public Orderitem() {
	}

	public Orderitem(Long id, String foodName, int quantity, double price, String imageUrl) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.quantity = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public Orderitem(String foodName, int quantity, double price, String imageUrl) {
		super();

		this.foodName = foodName;
		this.quantity = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
