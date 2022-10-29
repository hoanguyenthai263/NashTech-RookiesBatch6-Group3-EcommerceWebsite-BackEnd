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
import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.entity.Category;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	private ProductService productService;
	private CategoryService categoryService;
	private CategoryMapper categoryMapper;

	@Autowired
	public ProductController(ProductService productService, CategoryMapper categoryMapper,
			CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
		this.categoryMapper = categoryMapper;
	}

	@GetMapping("/category")
	public Map<String, Object> searchWithCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto)
			throws ResourceFoundException {
		Map<String, CategoryResponseDto> categoryResponseDto = categoryService.categoryWithId(categoryRequestDto);
		Category category = categoryMapper.responseToCategory(categoryResponseDto.get("data"));
		return productService.productListWithCategory(category);
	}

	@GetMapping("/id")
	public Map<String, ProductResponseDto> searchWithId(@Valid @RequestBody ProductRequestDto productRequestDto)
			throws ResourceFoundException {
		return productService.productWithId(productRequestDto);
	}

	@PostMapping("/create")
	public Map<String, Object> create(@Valid @RequestBody ProductRequestDto productRequestDto)
			throws ResourceFoundException {
		return productService.productCreate(productRequestDto);
	}

	@PutMapping("/update")
	public Map<String, Object> update(@Valid @RequestBody ProductRequestDto productRequestDto)
			throws ResourceFoundException {
		return productService.productUpdate(productRequestDto);
	}

	@PutMapping("/delete")
	public Map<String, Object> delete(@Valid @RequestBody ProductRequestDto productRequestDto)
			throws ResourceFoundException {
		return productService.productDelete(productRequestDto);
	}
}
