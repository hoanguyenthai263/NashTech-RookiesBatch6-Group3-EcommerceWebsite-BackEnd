package com.example.demo.dto.response;

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
public class CartResponseDto {
	private UUID id;
	private User user;
}
