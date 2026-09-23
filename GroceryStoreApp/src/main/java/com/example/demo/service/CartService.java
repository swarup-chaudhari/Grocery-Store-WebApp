package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	public Cart addToCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}
	public List<Cart> getCart(String email) {
		// TODO Auto-generated method stub
		return cartRepository.findByUserEmail(email);
	}
	public String clearCart(Long id) {
		 cartRepository.deleteById(id);
		 return "Removed Successfully";
		
	}

}
