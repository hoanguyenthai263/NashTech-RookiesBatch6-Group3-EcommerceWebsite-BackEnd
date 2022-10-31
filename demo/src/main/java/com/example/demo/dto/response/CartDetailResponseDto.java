package com.example.demo.dto.response;

import java.util.UUID;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetailResponseDto {
	private UUID id;
	private Integer quantity;
	private Cart cart;
	private Product product;
}
