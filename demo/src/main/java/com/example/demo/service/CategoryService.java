package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.entity.Category;
import com.example.demo.exception.ResourceFoundException;

public interface CategoryService {
	public Map<String, CategoryResponseDto> categoryWithId(CategoryRequestDto categoryRequestDto)
			throws ResourceFoundException;

	public Map<String, Object> categoryListWithCategory(Category category) throws ResourceFoundException;

	public Map<String, Object> categoryCreate(CategoryRequestDto categoryRequestDto) throws ResourceFoundException;

	public Map<String, Object> categoryUpdate(CategoryRequestDto categoryRequestDto) throws ResourceFoundException;
}
