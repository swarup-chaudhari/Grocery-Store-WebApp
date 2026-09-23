package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue
	Long id;
	String userEmail;
	double totalAmount;
	String phoneNumber;
	String address;
	LocalDateTime createdAt;
	String status;
	String paymentMethod;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Orderitem>orderitems;
	
	public Order() {}
	
	public Order(Long id, String userEmail, double totalAmount, String phoneNumber, String address,
			LocalDateTime createdAt, String status, String paymentMethod,List<Orderitem>orderitems) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.totalAmount = totalAmount;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.createdAt = createdAt;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.orderitems=orderitems;
	}
	
	public Order(String userEmail, double totalAmount, String phoneNumber, String address, LocalDateTime createdAt,
			String status, String paymentMethod,List<Orderitem>orderitems) {
		super();
		this.userEmail = userEmail;
		this.totalAmount = totalAmount;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.createdAt = createdAt;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.orderitems=orderitems;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<Orderitem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}
	
	
	

}
