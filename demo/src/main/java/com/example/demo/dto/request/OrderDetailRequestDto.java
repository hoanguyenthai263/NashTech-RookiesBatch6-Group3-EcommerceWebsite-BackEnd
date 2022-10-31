package com.example.demo.dto.request;

import java.util.UUID;

import com.example.demo.entity.Order;
import com.example.demo.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailRequestDto {
	private UUID id;
	private String product;
	private Long price;
	private Integer quantity;
	private Order order;
	private Product product_id;
}
