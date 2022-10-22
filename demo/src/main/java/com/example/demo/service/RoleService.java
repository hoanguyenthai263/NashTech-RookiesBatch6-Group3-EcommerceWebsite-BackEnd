package com.example.demo.service;

import com.example.demo.dto.RoleDto;
import com.example.demo.dto.request.UserRequestDtoLoadAll;
import com.example.demo.exception.ResourceFoundException;

public interface RoleService {
	public RoleDto findRoleById(UserRequestDtoLoadAll userRequestDtoLoadAll)
			throws ResourceFoundException;
}
