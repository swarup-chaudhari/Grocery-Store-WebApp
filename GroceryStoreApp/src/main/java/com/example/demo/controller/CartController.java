package com.example.demo.controller;

import com.example.demo.repository.CartRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

	private final CartRepository cartRepository;
	@Autowired 
	CartService cartService;

	CartController(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	@PostMapping("/add")
	public Cart addToCart(@RequestBody() Cart cart) {
		return cartService.addToCart(cart);
	}
	@GetMapping("/{email}")
	public List<Cart> getCart(@PathVariable("email")String email){
		return cartService.getCart(email);
	}
	
	@DeleteMapping("/items/{id}")
	public String clearCart(@PathVariable("id") Long id) {
		return cartService.clearCart(id);
	}
}
