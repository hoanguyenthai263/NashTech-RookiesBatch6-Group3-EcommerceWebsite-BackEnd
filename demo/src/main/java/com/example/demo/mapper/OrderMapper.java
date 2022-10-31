package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.entity.Order;

@Component
public class OrderMapper {
	public Order requestToOrder(OrderRequestDto orderRequestDto) {
		return Order.builder().id(orderRequestDto.getId()).email(orderRequestDto.getEmail())
				.phone(orderRequestDto.getPhone()).firstName(orderRequestDto.getFirstName())
				.lastName(orderRequestDto.getLastName()).streetAddress(orderRequestDto.getStreetAddress())
				.aptSuiteBuilding(orderRequestDto.getAptSuiteBuilding()).city(orderRequestDto.getCity())
				.district(orderRequestDto.getDistrict()).ward(orderRequestDto.getWard()).user(orderRequestDto.getUser())
				.build();
	}

	public OrderResponseDto orderToResponse(Order order) {
		return OrderResponseDto.builder().id(order.getId()).email(order.getEmail()).phone(order.getPhone())
				.firstName(order.getFirstName()).lastName(order.getLastName()).streetAddress(order.getStreetAddress())
				.aptSuiteBuilding(order.getAptSuiteBuilding()).city(order.getCity()).district(order.getDistrict())
				.ward(order.getWard()).status(order.getStatus()).user(order.getUser()).build();
	}
}
