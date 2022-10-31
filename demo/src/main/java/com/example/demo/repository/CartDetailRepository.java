package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CartDetail;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, UUID> {
	List<CartDetail> findByCart(Cart cart);
}
