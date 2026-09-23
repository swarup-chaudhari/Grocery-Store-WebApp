package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	List<Product>products;
	
	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product findProductById(Long id) {
		// TODO Auto-generated method stub
		
	
		return productRepository.findById(id).orElse(null);
	}
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		return "Product Added Successfully";
	}

	public String updateProduct(Product product, Long id) {
		// TODO Auto-generated method stub
		
		Product existing=productRepository.findById(id).orElse(null);
		
		if(existing==null) {
			return "Product Not Found";
		}
		existing.setName(product.getName());
		existing.setPrice(product.getPrice());
		existing.setCategory(product.getCategory());
		existing.setImageUrl(product.getImageUrl());
		
		productRepository.save(existing);
		
		
		return "Product updated Successfully";
	}

	public String deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		return "Deleted Successfully";
	}

	

}
