package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.entity.Category;

@Component
public class CategoryMapper {
	public Category requestToCategory(CategoryRequestDto categoryRequestDto) {
		return Category.builder().id(categoryRequestDto.getId()).build();
	}

	public CategoryResponseDto categoryToResponse(Category category) {
		return CategoryResponseDto.builder().id(category.getId()).category(category.getCategory())
				.categoryParent(category.getCategoryParent()).build();
	}

	public Category responseToCategory(CategoryResponseDto categoryResponseDto) {
		return Category.builder().id(categoryResponseDto.getId()).category(categoryResponseDto.getCategory())
				.categoryParent(categoryResponseDto.getCategoryParent()).build();
	}
}
