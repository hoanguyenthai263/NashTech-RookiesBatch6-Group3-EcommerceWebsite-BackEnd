package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
	List<Address> findByUserId(User userId);
}
