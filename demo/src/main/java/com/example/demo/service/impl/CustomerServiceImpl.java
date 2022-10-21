package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.response.CustomerResponseDto;
import com.example.demo.entity.Customer;
import com.example.demo.exception.ResourceFoundException;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository;
	private ModelMapper modalMapper;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modalMapper) {
		this.customerRepository = customerRepository;
		this.modalMapper = modalMapper;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public CustomerResponseDto getCustomerByEmail(String email) {
		Optional<Customer> customerOptional = this.customerRepository.findByEmail(email);
		if (customerOptional.isPresent()) {
			return modalMapper.map(customerOptional.get(), CustomerResponseDto.class);
		}
		throw new ResourceFoundException("Customer Not Found");
	};

}
