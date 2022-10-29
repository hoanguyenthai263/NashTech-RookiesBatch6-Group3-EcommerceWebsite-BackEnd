package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.entity.Category;
import com.example.demo.exception.ResourceFoundException;

public interface ProductService {
	public Map<String, Object> productListWithCategory(Category category) throws ResourceFoundException;

	public Map<String, ProductResponseDto> productWithId(ProductRequestDto productRequestDto)
			throws ResourceFoundException;

	public Map<String, Object> productCreate(ProductRequestDto productRequestDto) throws ResourceFoundException;

	public Map<String, Object> productUpdate(ProductRequestDto productRequestDto) throws ResourceFoundException;

	public Map<String, Object> productDelete(ProductRequestDto productRequestDto) throws ResourceFoundException;
}
