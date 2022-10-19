package com.example.demo.model;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Configuration
public class CustomerDTO {
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository repository) {
		return args -> {
			Customer customer = new Customer();
			customer.setFirstName("a");
			customer.setLastName("b");
			
			repository.saveAll(List.of(customer));
		};
	}
}
