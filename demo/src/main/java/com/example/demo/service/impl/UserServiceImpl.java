package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.jwt.JwtRequestDto;
import com.example.demo.jwt.JwtResponseDto;
import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.jwt.JwtUserDetail;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	AuthenticationManager authenticationManager;
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper,
			PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
			JwtTokenProvider jwtTokenProvider) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	private Map<String, Object> createUserAuthenticate(String jwt, Collection<? extends GrantedAuthority> role) {
		Map<String, Object> wrapper = new HashMap<>();
		JwtResponseDto jwtResponseDto = new JwtResponseDto(jwt, role);
		wrapper.put("data", jwtResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, Object> userAuthenticate(JwtRequestDto jwtRequestDto) throws ResourceFoundException {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(jwtRequestDto.getEmail(), jwtRequestDto.getPassWord()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		JwtUserDetail jwtUserDetail = (JwtUserDetail) authentication.getPrincipal();
		String jwt = jwtTokenProvider.generateToken(jwtUserDetail);
		return createUserAuthenticate(jwt, jwtUserDetail.getRole());
	}

	private Map<String, Object> createUsersListWithRole(List<User> list) {
		Map<String, Object> wrapper = new HashMap<>();
		Map<String, Object> dataWrapper = new HashMap<>();
		wrapper.put("data", dataWrapper);
		List<UserResponseDto> userWarrper = new ArrayList<>();
		dataWrapper.put("users", userWarrper);
		for (User user : list) {
			if (user.getStatus().equals(1)) {
				UserResponseDto userResponseDto = userMapper.userToResponse(user);
				userWarrper.add(userResponseDto);
			}
		}
		return wrapper;
	}

	@Override
	public Map<String, Object> usersListWithRole(Role role) throws ResourceFoundException {
		List<User> userList = userRepository.findByRoleId(role);
		if (userList.isEmpty()) {
			throw new ResourceFoundException("User not found");
		}
		return createUsersListWithRole(userList);
	}

	private Map<String, UserResponseDto> createUserWithId(User user) {
		Map<String, UserResponseDto> wrapper = new HashMap<>();
		UserResponseDto userResponseDto = userMapper.userToResponse(user);
		wrapper.put("data", userResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, UserResponseDto> userWithId(UserRequestDto userRequestDto) throws ResourceFoundException {
		Optional<User> userOptional = userRepository.findById(userRequestDto.getId());
		if (userOptional.isEmpty()) {
			throw new ResourceFoundException("User not found");
		}
		User user = userOptional.get();
		return createUserWithId(user);
	}

	private Map<String, Object> createUserRegister(User user) {
		Map<String, Object> wrapper = new HashMap<>();
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
			throw new ResourceFoundException("Phone already in use");
		}
		User user = userMapper.requestToUser(userRequestDto);
		Optional<Role> roleOptional = roleRepository.findByRole("User");
		if (roleOptional.isEmpty()) {
			throw new ResourceFoundException("Role not found");
		}
		user.setRoleId(roleOptional.get());
		user.setPassWord(passwordEncoder.encode(user.getPassWord()));
		userRepository.save(user);
		return createUserRegister(user);
	}

	private Map<String, Object> createUserUpdate(User user) {
		Map<String, Object> wrapper = new HashMap<>();
		UserResponseDto userDTOResponse = userMapper.userToResponse(user);
		wrapper.put("data", userDTOResponse);
		return wrapper;
	}

	@Override
	public Map<String, Object> userUpdate(UserRequestDto userRequestDto) throws ResourceFoundException {
		Optional<User> userOptional = userRepository.findById(userRequestDto.getId());
		if (userOptional.isEmpty()) {
			throw new ResourceFoundException("User not found");
		}
		Integer statusOptional = userOptional.get().getStatus();
		if (statusOptional.equals(0)) {
			throw new ResourceFoundException("User not found");
		}
		User user = userMapper.requestToUser(userRequestDto);
		user.setStatus(statusOptional);
		user.setRoleId(userOptional.get().getRoleId());
		user.setPassWord(passwordEncoder.encode(user.getPassWord()));
		userRepository.save(user);
		return createUserUpdate(user);
	}

	private Map<String, Object> createUserDelete(User user) {
		Map<String, Object> wrapper = new HashMap<>();
		UserResponseDto userDTOResponse = userMapper.userToResponse(user);
		wrapper.put("data", userDTOResponse);
		return wrapper;
	}

	@Override
	public Map<String, Object> userDelete(UserRequestDto userRequestDto) throws ResourceFoundException {
		Optional<User> userOptional = userRepository.findById(userRequestDto.getId());
		if (userOptional.isEmpty()) {
			throw new ResourceFoundException("User not found");
		}
		Integer statusOptional = userOptional.get().getStatus();
		if (statusOptional.equals(0)) {
			throw new ResourceFoundException("User not found");
		}
		User user = userOptional.get();
		user.setStatus(0);
		userRepository.save(user);
		return createUserDelete(user);
	}
}
