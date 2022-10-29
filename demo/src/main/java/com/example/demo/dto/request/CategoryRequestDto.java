package com.example.demo.dto.request;

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
public class CategoryRequestDto {
	private UUID id;
	private String category;
	private Category categoryParent;
}
