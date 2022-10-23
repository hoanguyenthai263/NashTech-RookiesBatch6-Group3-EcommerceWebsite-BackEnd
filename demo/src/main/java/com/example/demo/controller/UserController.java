package com.example.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.RoleRequestDto;
import com.example.demo.dto.response.RoleResponseDto;
import com.example.demo.entity.Role;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	private UserService userService;
	private RoleService roleService;

	@Autowired
	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@GetMapping
	public Map<String, Object> findUserByRoleId(@Valid @RequestBody RoleRequestDto roleRequestDto)
			throws ResourceFoundException {
		Map<String, RoleResponseDto> roleResponseDto = roleService.findRoleById(roleRequestDto);
		Role role = RoleMapper.responseToRole(roleResponseDto.get("data"));;
		return userService.findUserByRole(role);
	}
}
