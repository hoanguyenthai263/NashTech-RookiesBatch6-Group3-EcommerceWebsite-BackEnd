package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.response.CustomerResponseDto;
import com.example.demo.entity.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();

	public CustomerResponseDto getCustomerByEmail(String email);
	
}
