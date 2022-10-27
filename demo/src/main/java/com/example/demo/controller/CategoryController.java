package com.example.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/id")
	public Map<String, CategoryResponseDto> searchWithId(@Valid @RequestBody CategoryRequestDto categoryRequestDto)
			throws ResourceFoundException {
		return categoryService.categoryWithId(categoryRequestDto);
	}
}
