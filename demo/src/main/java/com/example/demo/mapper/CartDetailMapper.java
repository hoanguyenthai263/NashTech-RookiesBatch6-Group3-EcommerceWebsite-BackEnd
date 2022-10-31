package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.CartDetailRequestDto;
import com.example.demo.dto.response.CartDetailResponseDto;
import com.example.demo.entity.CartDetail;

@Component
public class CartDetailMapper {
	public CartDetail requestToCartDetail(CartDetailRequestDto cartDetailRequestDto) {
		return CartDetail.builder().id(cartDetailRequestDto.getId()).quantity(cartDetailRequestDto.getQuantity())
				.cart(cartDetailRequestDto.getCart()).product(cartDetailRequestDto.getProduct()).build();
	}

	public CartDetailResponseDto cartDetailToResponse(CartDetail cartDetail) {
		return CartDetailResponseDto.builder().id(cartDetail.getId()).quantity(cartDetail.getQuantity())
				.cart(cartDetail.getCart()).product(cartDetail.getProduct()).build();
	}
}
