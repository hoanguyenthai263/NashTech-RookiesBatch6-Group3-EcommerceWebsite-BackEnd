package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.AddressRequestDto;
import com.example.demo.dto.response.AddressResponseDto;
import com.example.demo.entity.Address;

@Component
public class AddressMapper {
	public Address requestToAddress(AddressRequestDto addressRequestDto) {
		return Address.builder().id(addressRequestDto.getId()).streetAddress(addressRequestDto.getStreetAddress())
				.aptSuiteBuilding(addressRequestDto.getAptSuiteBuilding()).city(addressRequestDto.getCity())
				.district(addressRequestDto.getDistrict()).ward(addressRequestDto.getWard())
				.userId(addressRequestDto.getUserId()).build();
	}

	public AddressResponseDto addressToResponse(Address address) {
		return AddressResponseDto.builder().id(address.getId()).streetAddress(address.getStreetAddress())
				.aptSuiteBuilding(address.getAptSuiteBuilding()).city(address.getCity()).district(address.getDistrict())
				.ward(address.getWard()).userId(address.getUserId()).status(address.getStatus()).build();
	}
}
