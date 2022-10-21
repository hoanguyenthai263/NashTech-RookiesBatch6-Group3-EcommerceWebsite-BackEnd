package com.example.demo.dto.response;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerResponseDto {
	private UUID idCustomer;
	private String firstName;
	private String lastName;

	@JsonProperty(value = "email", required = true, defaultValue = "No email", access = Access.READ_WRITE)
	private String email;
	
}
