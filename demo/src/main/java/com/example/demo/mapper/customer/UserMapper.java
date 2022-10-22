package com.example.demo.mapper.customer;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.UserRequestDtoLoadAll;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.entity.User;

@Component
public class UserMapper {
	/*
	 * public User requestToUserLoadAll(UserRequestDtoLoadAll userRequestDtoLoadAll)
	 * { return User.builder().role(userRequestDtoLoadAll.getId()).build(); }
	 */

	public UserResponseDto userToResponse(User user) {
		return UserResponseDto.builder().id(user.getId()).email(user.getEmail()).phone(user.getPhone())
				.firstName(user.getFirstName()).lastName(user.getLastName()).status(user.getStatus())
				.role(user.getRole()).build();
	}
}
