package com.example.demo.dto.response;

import java.util.UUID;

import com.example.demo.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {
	private UUID id;
	private String category;
	private Category categoryParent;
}
