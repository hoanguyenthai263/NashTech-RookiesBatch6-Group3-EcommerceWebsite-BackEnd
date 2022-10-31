package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Order;
import com.example.demo.entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
	List<Order> findByUser(User user);
}
