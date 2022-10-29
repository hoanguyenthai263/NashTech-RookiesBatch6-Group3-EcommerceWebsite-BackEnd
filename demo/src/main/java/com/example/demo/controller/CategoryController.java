package com.example.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.entity.Category;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	private CategoryService categoryService;
	private CategoryMapper categoryMapper;

	@Autowired
	public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
		this.categoryService = categoryService;
		this.categoryMapper = categoryMapper;
	}

	@GetMapping("/id")
	public Map<String, CategoryResponseDto> searchWithId(@Valid @RequestBody CategoryRequestDto categoryRequestDto)
			throws ResourceFoundException {
		return categoryService.categoryWithId(categoryRequestDto);
	}

	@GetMapping("/categoryParent")
	public Map<String, Object> searchWithCategoryParent(@Valid @RequestBody CategoryRequestDto categoryRequestDto)
			throws ResourceFoundException {
		Category category = categoryMapper.requestToCategory(categoryRequestDto);
		return categoryService.categoryListWithCategory(category);
	}

	@PostMapping("/create")
	public Map<String, Object> create(@Valid @RequestBody CategoryRequestDto categoryRequestDto)
			throws ResourceFoundException {
		return categoryService.categoryCreate(categoryRequestDto);
	}

	@PutMapping("/update")
	public Map<String, Object> update(@Valid @RequestBody CategoryRequestDto categoryRequestDto)
			throws ResourceFoundException {
		return categoryService.categoryUpdate(categoryRequestDto);
	}
}
