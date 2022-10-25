package com.example.demo.dto.response;

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
public class AddressResponseDto {
	private UUID id;
	private String streetAddress;
	private String aptSuiteBuilding;
	private String city;
	private String district;
	private String ward;
	private Integer status;
	private User userId;
}
