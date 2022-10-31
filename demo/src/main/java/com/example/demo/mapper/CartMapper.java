package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.CartRequestDto;
import com.example.demo.dto.response.CartResponseDto;
import com.example.demo.entity.Cart;

@Component
public class CartMapper {
	public Cart requestToCart(CartRequestDto cartRequestDto) {
		return Cart.builder().id(cartRequestDto.getId()).user(cartRequestDto.getUser()).build();
	}

	public CartResponseDto cartToResponse(Cart cart) {
		return CartResponseDto.builder().id(cart.getId()).user(cart.getUser()).build();
	}
}
