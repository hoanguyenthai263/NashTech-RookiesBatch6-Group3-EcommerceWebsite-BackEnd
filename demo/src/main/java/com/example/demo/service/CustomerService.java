package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public void addNewCustomer(Customer customer) {
		Optional<Customer> customerOptional = customerRepository.findByFirstName(customer.getFirstName());
		if (customerOptional.isPresent()) {
			throw new IllegalStateException("Name taken");
		}
		customerRepository.save(customer);
	}
}
