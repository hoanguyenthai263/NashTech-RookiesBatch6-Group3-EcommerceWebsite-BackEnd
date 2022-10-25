package com.example.demo.dto.request;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
	private UUID id;
	private String email;
	private String phone;
	private String firstName;
	private String lastName;
	private String passWord;
}
