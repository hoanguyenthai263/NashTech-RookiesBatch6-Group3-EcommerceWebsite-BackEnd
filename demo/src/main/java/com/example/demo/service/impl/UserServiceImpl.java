package com.example.demo.service.impl;

import java.util.ArrayList;
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

	private Map<String, Object> initUserResponseDto(List<User> list) {
		Map<String, Object> wrapper = new HashMap<>();
		Map<String, Object> dataWrapper = new HashMap<>();
		wrapper.put("data", dataWrapper);
		List<UserResponseDto> userWarrper = new ArrayList<>();
		dataWrapper.put("users", userWarrper);
		for (User user : list) {
			UserResponseDto userResponseDto = userMapper.userToResponse(user);
			userWarrper.add(userResponseDto);
		}
		return wrapper;
	}

	@Override
	public Map<String, Object> findUserByRole(Role role) throws ResourceFoundException {
		List<User> userList = userRepository.findByRoleId(role);
		if (userList.isEmpty()) {
			throw new ResourceFoundException("User not found");
		}
		return initUserResponseDto(userList);
	}

}
