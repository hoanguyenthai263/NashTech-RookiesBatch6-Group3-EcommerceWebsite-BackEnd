package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.entity.User;

@Component
public class UserMapper {
	public User requestToUser(UserRequestDto userRequestDto) {
		return User.builder().id(userRequestDto.getId()).email(userRequestDto.getEmail())
				.phone(userRequestDto.getPhone()).firstName(userRequestDto.getFirstName())
				.lastName(userRequestDto.getLastName()).passWord(userRequestDto.getPassWord()).build();
	}

	public UserResponseDto userToResponse(User user) {
		return UserResponseDto.builder().id(user.getId()).email(user.getEmail()).phone(user.getPhone())
				.firstName(user.getFirstName()).lastName(user.getLastName()).status(user.getStatus())
				.role(user.getRoleId()).build();
	}

	public User responseToRole(UserResponseDto userResponseDto) {
		return User.builder().id(userResponseDto.getId()).email(userResponseDto.getEmail())
				.phone(userResponseDto.getPhone()).firstName(userResponseDto.getFirstName())
				.lastName(userResponseDto.getLastName()).status(userResponseDto.getStatus())
				.roleId(userResponseDto.getRole()).build();
	}
}
