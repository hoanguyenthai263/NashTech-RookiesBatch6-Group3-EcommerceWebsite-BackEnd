package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.entity.Role;
import com.example.demo.exception.ResourceFoundException;

public interface UserService {
	public Map<String, Object> usersListWithRole(Role role) throws ResourceFoundException;

	public Map<String, Object> userRegister(UserRequestDto userRequestDto) throws ResourceFoundException;

	public Map<String, Object> userUpdate(UserRequestDto userRequestDto) throws ResourceFoundException;
	
	public Map<String, Object> userDelete(UserRequestDto userRequestDto) throws ResourceFoundException;
	
	public Map<String, UserResponseDto> userWithId(UserRequestDto userRequestDto) throws ResourceFoundException;
}
