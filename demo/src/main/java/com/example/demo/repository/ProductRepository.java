package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
	List<Product> findByCategory(Category category);

	Optional<Product> findById(UUID id);

	Optional<Product> findByProduct(String product);
}
