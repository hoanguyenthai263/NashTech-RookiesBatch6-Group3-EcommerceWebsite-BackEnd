package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RoleDto;
import com.example.demo.dto.request.UserRequestDtoLoadAll;
import com.example.demo.entity.Role;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	private final RoleRepository roleRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	
	@Override
	public RoleDto findRoleById(UserRequestDtoLoadAll userRequestDtoLoadAll)
			throws ResourceFoundException {
		Optional<Role> roleOptional = roleRepository.findById(userRequestDtoLoadAll.getId());
		if (roleOptional.isPresent()) {
			Role role = roleOptional.get();
			return new RoleDto(role);
		} else
			throw new ResourceFoundException("No user in database");
	}

}
