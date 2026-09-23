package com.example.demo.service;

import com.example.demo.repository.OrderItemRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderRequest;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;
import com.example.demo.entity.Orderitem;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	private final OrderItemRepository orderItemRepository;

	@Autowired
	CartRepository cartRepository;

	@Autowired
	OrderRepository orderRepository;

	OrderService(OrderItemRepository orderItemRepository) {
		this.orderItemRepository = orderItemRepository;
	}

	@Transactional

	public Order placeOrder(OrderRequest request) {

		List<Cart> cartitems = cartRepository.findByUserEmail(request.getEmail());

		if (cartitems.isEmpty()) {
			throw new RuntimeException("Cart is Empty");
		}

		double total = 0;

		for (Cart item : cartitems) {
			total += item.getPrice() * item.getQuantity();
		}

		Order order = new Order();
		order.setUserEmail(request.getEmail());
		order.setTotalAmount(total);
		order.setStatus("PLACED");
		order.setAddress(request.getAddress());
		order.setPhoneNumber(request.getPhoneNumber());
		order.setPaymentMethod(request.getPaymentMethod());
		order.setCreatedAt(LocalDateTime.now());

		// 🔥 CREATE ORDER ITEMS LIST
		List<Orderitem> orderItemsList = new ArrayList<>();

		for (Cart item : cartitems) {
			Orderitem orderitem = new Orderitem();

			orderitem.setOrder(order); // 🔥 VERY IMPORTANT
			orderitem.setFoodName(item.getFoodName());
			orderitem.setPrice(item.getPrice());
			orderitem.setQuantity(item.getQuantity());
			orderitem.setImageUrl(item.getImageUrl());

			orderItemsList.add(orderitem);
		}

		// 🔥 LINK BOTH SIDES
		order.setOrderitems(orderItemsList);

		// 🔥 SAVE ONLY ORDER (cascade will save items)
		Order savedOrder = orderRepository.save(order);

		// clear cart
		cartRepository.deleteByUserEmail(request.getEmail());

		return savedOrder;
	}

	public List<Order> getOrdersByEmail(String email) {
		return orderRepository.findByUserEmail(email);
	}

	public Order cancelOrder(Long id) {
		// TODO Auto-generated method stub
		Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order Not Found"));

		order.setStatus("Cancelled");
		return orderRepository.save(order);
	}

}
