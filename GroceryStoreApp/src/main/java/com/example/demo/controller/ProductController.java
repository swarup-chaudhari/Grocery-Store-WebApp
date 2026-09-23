package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id")Long id) {
		return productService.findProductById(id);
	}
	@PostMapping("/products")
	public String addProduct(@RequestBody()Product product) {
		return productService.addProduct(product);
	}
	@PutMapping("/products/{id}")
	public String updateProduct(@RequestBody()Product product,@PathVariable("id")Long id) {
		return productService.updateProduct(product,id);
	}
	@DeleteMapping("/products/{id}")
	public String deletProduct(@PathVariable("id")Long id) {
		return productService.deleteProduct(id);
	}

}
