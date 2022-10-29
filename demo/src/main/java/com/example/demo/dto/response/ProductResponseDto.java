package com.example.demo.dto.response;

import java.util.UUID;

import com.example.demo.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
	private UUID id;
	private String product;
	private Long price;
	private String description;
	private Integer status;
	private Category category;
}
