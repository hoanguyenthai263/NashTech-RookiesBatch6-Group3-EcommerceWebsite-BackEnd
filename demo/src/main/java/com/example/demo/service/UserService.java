package com.example.demo.service;

import java.util.Map;

import com.example.demo.entity.Role;
import com.example.demo.exception.ResourceFoundException;

public interface UserService {
	public Map<String, Object> findUserByRole(Role role) throws ResourceFoundException;
}
