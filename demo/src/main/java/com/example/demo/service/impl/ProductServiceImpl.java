package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.ProductRequestDto;
import com.example.demo.dto.response.ProductResponseDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	private Map<String, Object> createProductListWithCategory(List<Product> list) {
		Map<String, Object> wrapper = new HashMap<>();
		Map<String, Object> dataWrapper = new HashMap<>();
		wrapper.put("data", dataWrapper);
		List<ProductResponseDto> productWarrper = new ArrayList<>();
		dataWrapper.put("products", productWarrper);
		for (Product product : list) {
			if (product.getStatus().equals(1)) {
				ProductResponseDto productResponseDto = productMapper.productToResponse(product);
				productWarrper.add(productResponseDto);
			}
		}
		return wrapper;
	}

	@Override
	public Map<String, Object> productListWithCategory(Category category) throws ResourceFoundException {
		List<Product> productList = productRepository.findByCategory(category);
		if (productList.isEmpty()) {
			throw new ResourceFoundException("Product not found");
		}
		return createProductListWithCategory(productList);
	}

	private Map<String, ProductResponseDto> createProductWithId(Product product) {
		Map<String, ProductResponseDto> wrapper = new HashMap<>();
		ProductResponseDto productResponseDto = productMapper.productToResponse(product);
		wrapper.put("data", productResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, ProductResponseDto> productWithId(ProductRequestDto productRequestDto)
			throws ResourceFoundException {
		Optional<Product> productOptional = productRepository.findById(productRequestDto.getId());
		if (productOptional.isEmpty()) {
			throw new ResourceFoundException("Product not found");
		}
		Product product = productOptional.get();
		return createProductWithId(product);
	}

	private Map<String, Object> createProductCreate(Product product) {
		Map<String, Object> wrapper = new HashMap<>();
		ProductResponseDto productResponseDto = productMapper.productToResponse(product);
		wrapper.put("data", productResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, Object> productCreate(ProductRequestDto productRequestDto) throws ResourceFoundException {
		Optional<Product> productOptional = productRepository.findByProduct(productRequestDto.getProduct());
		if (productOptional.isPresent()) {
			throw new ResourceFoundException("Product already in use");
		}
		Product product = productMapper.requestToProduct(productRequestDto);
		productRepository.save(product);
		return createProductCreate(product);
	}

	private Map<String, Object> createProductUpdate(Product product) {
		Map<String, Object> wrapper = new HashMap<>();
		ProductResponseDto productResponseDto = productMapper.productToResponse(product);
		wrapper.put("data", productResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, Object> productUpdate(ProductRequestDto productRequestDto) throws ResourceFoundException {
		Optional<Product> productOptional = productRepository.findById(productRequestDto.getId());
		if (productOptional.isEmpty()) {
			throw new ResourceFoundException("Product not found");
		}
		Integer statusOptional = productOptional.get().getStatus();
		if (statusOptional.equals(0)) {
			throw new ResourceFoundException("Product not found");
		}
		Product product = productMapper.requestToProduct(productRequestDto);
		product.setStatus(statusOptional);
		productRepository.save(product);
		return createProductUpdate(product);
	}

	private Map<String, Object> createProductDelete(Product product) {
		Map<String, Object> wrapper = new HashMap<>();
		ProductResponseDto productResponseDto = productMapper.productToResponse(product);
		wrapper.put("data", productResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, Object> productDelete(ProductRequestDto productRequestDto) throws ResourceFoundException {
		Optional<Product> productOptional = productRepository.findById(productRequestDto.getId());
		if (productOptional.isEmpty()) {
			throw new ResourceFoundException("Product not found");
		}
		Integer statusOptional = productOptional.get().getStatus();
		if (statusOptional.equals(0)) {
			throw new ResourceFoundException("Product not found");
		}
		Product product = productOptional.get();
		product.setStatus(0);
		productRepository.save(product);
		return createProductDelete(product);
	}

}
