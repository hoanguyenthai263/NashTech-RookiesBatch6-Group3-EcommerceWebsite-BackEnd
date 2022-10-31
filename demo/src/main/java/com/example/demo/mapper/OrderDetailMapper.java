package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.OrderDetailRequestDto;
import com.example.demo.dto.response.OrderDetailResponseDto;
import com.example.demo.entity.OrderDetail;

@Component
public class OrderDetailMapper {
	public OrderDetail requestToOrderDetail(OrderDetailRequestDto orderDetailRequestDto) {
		return OrderDetail.builder().id(orderDetailRequestDto.getId()).product(orderDetailRequestDto.getProduct())
				.price(orderDetailRequestDto.getPrice()).quantity(orderDetailRequestDto.getQuantity())
				.order(orderDetailRequestDto.getOrder()).product_id(orderDetailRequestDto.getProduct_id()).build();
	}

	public OrderDetailResponseDto orderDetailToResponse(OrderDetail orderDetail) {
		return OrderDetailResponseDto.builder().id(orderDetail.getId()).product(orderDetail.getProduct())
				.price(orderDetail.getPrice()).quantity(orderDetail.getQuantity()).order(orderDetail.getOrder())
				.product_id(orderDetail.getProduct_id()).build();
	}
}
