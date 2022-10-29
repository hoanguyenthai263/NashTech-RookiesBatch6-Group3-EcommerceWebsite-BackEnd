package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.entity.Category;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
	}

	private Map<String, CategoryResponseDto> createCategoryWithId(Category category) {
		Map<String, CategoryResponseDto> wrapper = new HashMap<>();
		CategoryResponseDto categoryResponseDto = categoryMapper.categoryToResponse(category);
		wrapper.put("data", categoryResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, CategoryResponseDto> categoryWithId(CategoryRequestDto categoryRequestDto)
			throws ResourceFoundException {
		Optional<Category> categoryOptional = categoryRepository.findById(categoryRequestDto.getId());
		if (categoryOptional.isEmpty()) {
			throw new ResourceFoundException("Category not found");
		}
		Category category = categoryOptional.get();
		return createCategoryWithId(category);
	}

	private Map<String, Object> createCategoryListWithCategory(List<Category> list) {
		Map<String, Object> wrapper = new HashMap<>();
		Map<String, Object> dataWrapper = new HashMap<>();
		wrapper.put("data", dataWrapper);
		List<CategoryResponseDto> categoryWarrper = new ArrayList<>();
		dataWrapper.put("categories", categoryWarrper);
		for (Category category : list) {
			CategoryResponseDto categoryResponseDto = categoryMapper.categoryToResponse(category);
			categoryWarrper.add(categoryResponseDto);
		}
		return wrapper;
	}

	@Override
	public Map<String, Object> categoryListWithCategory(Category category) throws ResourceFoundException {
		Optional<Category> categoryOptional = categoryRepository.findById(category.getId());
		if (categoryOptional.isEmpty()) {
			throw new ResourceFoundException("Category parent not found");
		}
		List<Category> categoryList = categoryRepository.findByCategoryParent(categoryOptional.get());
		if (categoryList.isEmpty()) {
			throw new ResourceFoundException("Category not found");
		}
		return createCategoryListWithCategory(categoryList);
	}

	private Map<String, Object> createCategoryCreate(Category category) {
		Map<String, Object> wrapper = new HashMap<>();
		CategoryResponseDto categoryDTOResponse = categoryMapper.categoryToResponse(category);
		wrapper.put("data", categoryDTOResponse);
		return wrapper;
	}

	@Override
	public Map<String, Object> categoryCreate(CategoryRequestDto categoryRequestDto) throws ResourceFoundException {
		Optional<Category> categoryOptional = categoryRepository.findByCategory(categoryRequestDto.getCategory());
		if (categoryOptional.isPresent()) {
			throw new ResourceFoundException("Category already in use");
		}
		Category category = categoryMapper.requestToCategory(categoryRequestDto);
		categoryRepository.save(category);
		return createCategoryCreate(category);
	}

	private Map<String, Object> createCategoryUpdate(Category category) {
		Map<String, Object> wrapper = new HashMap<>();
		CategoryResponseDto categoryDTOResponse = categoryMapper.categoryToResponse(category);
		wrapper.put("data", categoryDTOResponse);
		return wrapper;
	}

	@Override
	public Map<String, Object> categoryUpdate(CategoryRequestDto categoryRequestDto) throws ResourceFoundException {
		Optional<Category> categoryOptional = categoryRepository.findById(categoryRequestDto.getId());
		if (categoryOptional.isEmpty()) {
			throw new ResourceFoundException("Category not found");
		}
		Category category = categoryMapper.requestToCategory(categoryRequestDto);
		categoryRepository.save(category);
		return createCategoryUpdate(category);
	}
}
