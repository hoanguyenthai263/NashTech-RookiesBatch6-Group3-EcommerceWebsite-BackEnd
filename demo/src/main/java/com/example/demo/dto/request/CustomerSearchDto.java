package com.example.demo.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CustomerSearchDto {
	private String firstName;
	private String lastName;
	
	@NotBlank(message="Email is required")
	private String email;
	
}
