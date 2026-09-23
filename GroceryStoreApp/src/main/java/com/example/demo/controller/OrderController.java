package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderRequest;
import com.example.demo.entity.Order;
import com.example.demo.entity.Orderitem;
import com.example.demo.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/place")
	public Order placeOrder(@RequestBody OrderRequest request) {
		
		return orderService.placeOrder(request);
	}
	
	@GetMapping("/{email}")
	public List<Order> getOrders(@PathVariable String email) {
	    return orderService.getOrdersByEmail(email);
	}
	
	@PutMapping("/cancel/{id}")
	public Order cancelOrder(@PathVariable("id")Long id) {
		return orderService.cancelOrder(id);
	}
	
	
	

}
