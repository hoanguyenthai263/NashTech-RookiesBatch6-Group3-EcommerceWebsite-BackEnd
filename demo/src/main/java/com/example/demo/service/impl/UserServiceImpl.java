package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	private Map<String, UserResponseDto> initUserResponseDto(User user) {
		Map<String, UserResponseDto> wrapper = new HashMap<>();
		UserResponseDto userResponseDto = userMapper.userToResponse(user);
		wrapper.put("data", userResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, UserResponseDto> findUserByRole(Role role) throws ResourceFoundException {
		List<User> userList = userRepository.findByRoleId(role);
		if (userList.isEmpty()) {
			throw new ResourceFoundException("User not found");
		}
		User user = userList.get(0);
		return initUserResponseDto(user);
	}

}
