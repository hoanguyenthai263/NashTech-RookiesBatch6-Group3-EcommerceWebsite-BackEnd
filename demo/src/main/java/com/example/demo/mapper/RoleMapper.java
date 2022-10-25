package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.RoleRequestDto;
import com.example.demo.dto.response.RoleResponseDto;
import com.example.demo.entity.Role;

@Component
public class RoleMapper {
	public Role requestToRole(RoleRequestDto roleRequestDto) {
		return Role.builder().id(roleRequestDto.getId()).build();
	}

	public RoleResponseDto roleToResponse(Role role) {
		return RoleResponseDto.builder().id(role.getId()).role(role.getRole()).build();
	}
	
	public Role responseToRole(RoleResponseDto roleResponseDto) {
		return Role.builder().id(roleResponseDto.getId()).role(roleResponseDto.getRole()).build();
	}
}
