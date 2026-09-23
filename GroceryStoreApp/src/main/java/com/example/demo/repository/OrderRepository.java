package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Order;
import com.example.demo.entity.Orderitem;

@Repository
public interface  OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByUserEmail(String email);
	

}
