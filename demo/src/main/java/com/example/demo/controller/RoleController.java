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
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
	private RoleService roleService;

	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@GetMapping
	public Map<String, RoleResponseDto> findRoleById(@Valid @RequestBody RoleRequestDto roleRequestDto)
			throws ResourceFoundException {
		return roleService.findRoleById(roleRequestDto);
	}
}
