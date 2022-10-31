package com.example.demo.dto.request;

import java.util.UUID;

import com.example.demo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDto {
	private UUID id;
	private User user;
}
