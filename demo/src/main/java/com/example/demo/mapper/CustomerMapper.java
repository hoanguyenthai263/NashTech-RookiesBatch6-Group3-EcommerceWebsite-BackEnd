package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.response.CustomerResponseDto;
import com.example.demo.entity.Customer;

@Component
public class CustomerMapper {
	public CustomerResponseDto mapEntityToDto(Customer customer) {
		return CustomerResponseDto.builder().idCustomer(customer.getIdCustomer()).firstName(customer.getFirstName())
				.lastName(customer.getLastName()).email(customer.getEmail()).build();
	}
}
