package com.example.demo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID>{
	Optional<Cart> findByUser(User user);
}
