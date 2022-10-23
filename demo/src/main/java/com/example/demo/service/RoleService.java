package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.request.RoleRequestDto;
import com.example.demo.dto.response.RoleResponseDto;
import com.example.demo.exception.ResourceFoundException;

public interface RoleService {
	public Map<String, RoleResponseDto> findRoleById(RoleRequestDto roleRequestDto) throws ResourceFoundException;
}
