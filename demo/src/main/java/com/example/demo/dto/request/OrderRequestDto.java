package com.example.demo.dto.request;

import java.util.UUID;

import com.example.demo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
	private UUID id;
	private String email;
	private String phone;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String aptSuiteBuilding;
	private String city;
	private String district;
	private String ward;
	private User user;
}
