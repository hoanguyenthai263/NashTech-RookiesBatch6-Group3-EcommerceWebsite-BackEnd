package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
	List<User> findByRoleId(Role roleId);

	Optional<User> findByEmail(String email);

	Optional<User> findByPhone(String phone);

}