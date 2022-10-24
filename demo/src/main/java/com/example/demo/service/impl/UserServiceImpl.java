package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final RoleRepository roleRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.roleRepository = roleRepository;
	}

	private Map<String, Object> createSearchUserWithRole(List<User> list) {
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
	public Map<String, Object> usersListWithRole(Role role) throws ResourceFoundException {
		List<User> userList = userRepository.findByRoleId(role);
		if (userList.isEmpty()) {
			throw new ResourceFoundException("User not found");
		}
		return createSearchUserWithRole(userList);
	}

	private Map<String, Object> createAddUser(User user) {
		Map<String, Object> wrapper = new HashMap<>();
		Map<String, Object> dataWrapper = new HashMap<>();
		wrapper.put("data", dataWrapper);
		UserResponseDto userDTOResponse = userMapper.userToResponse(user);
		wrapper.put("data", userDTOResponse);
		return wrapper;
	}

	@Override
	public Map<String, Object> userRegister(UserRequestDto userRequestDto) throws ResourceFoundException {
		Optional<User> userOptional = userRepository.findByEmail(userRequestDto.getEmail());
		if (userOptional.isPresent()) {
			throw new ResourceFoundException("Email already in use");
		}
		userOptional = userRepository.findByPhone(userRequestDto.getPhone());
		if (userOptional.isPresent()) {
			throw new ResourceFoundException("Phong already in use");
		}
		User user = userMapper.requestToUser(userRequestDto);
		Optional<Role> roleOptional = roleRepository.findByRole("User");
		if (roleOptional.isEmpty()) {
			throw new ResourceFoundException("Role not found");
		}
		user.setRoleId(roleOptional.get());
		userRepository.save(user);
		return createAddUser(user);
	}
}
