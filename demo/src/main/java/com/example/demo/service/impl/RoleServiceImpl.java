package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.RoleRequestDto;
import com.example.demo.dto.response.RoleResponseDto;
import com.example.demo.entity.Role;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	private final RoleRepository roleRepository;
	private final RoleMapper roleMapper;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
		this.roleRepository = roleRepository;
		this.roleMapper = roleMapper;
	}

	private Map<String, RoleResponseDto> createSearchRoleWithId(Role role) {
		Map<String, RoleResponseDto> wrapper = new HashMap<>();
		RoleResponseDto roleResponseDto = roleMapper.roleToResponse(role);
		wrapper.put("data", roleResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, RoleResponseDto> roleWithId(RoleRequestDto roleRequestDto) throws ResourceFoundException {
		Optional<Role> roleOptional = roleRepository.findById(roleRequestDto.getId());
		if (roleOptional.isEmpty()) {
			throw new ResourceFoundException("Role not found");
		}
		Role role = roleOptional.get();
		return createSearchRoleWithId(role);
	}
}
