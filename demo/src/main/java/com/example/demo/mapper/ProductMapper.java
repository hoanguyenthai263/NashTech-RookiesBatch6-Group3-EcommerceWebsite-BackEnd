package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.entity.Product;

@Component
public class ProductMapper {
	public Product requestToProduct(ProductRequestDto productRequestDto) {
		return Product.builder().id(productRequestDto.getId()).product(productRequestDto.getProduct())
				.price(productRequestDto.getPrice()).description(productRequestDto.getDescription())
				.category(productRequestDto.getCategory()).build();
	}

	public ProductResponseDto productToResponse(Product product) {
		return ProductResponseDto.builder().id(product.getId()).product(product.getProduct()).price(product.getPrice())
				.description(product.getDescription()).status(product.getStatus()).category(product.getCategory())
				.build();
	}
}
