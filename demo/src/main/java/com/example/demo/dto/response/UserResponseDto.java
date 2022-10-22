package com.example.demo.dto.response;

import java.util.UUID;

import com.example.demo.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
	private UUID id;
	private String email;
	private String phone;
	private String firstName;
	private String lastName;
	private Integer status;
	private Role role;
}
