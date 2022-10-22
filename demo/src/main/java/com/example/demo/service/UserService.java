package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.RoleDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.exception.ResourceFoundException;

public interface UserService {
	public Map<String, UserResponseDto> findUserByRole(RoleDto roleDto)
			throws ResourceFoundException;
}
