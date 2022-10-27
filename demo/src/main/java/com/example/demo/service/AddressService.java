package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.request.AddressRequestDto;
import com.example.demo.dto.response.AddressResponseDto;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceFoundException;

public interface AddressService {
	public Map<String, Object> addressListWithUser(User user) throws ResourceFoundException;

	public Map<String, AddressResponseDto> addressWithId(AddressRequestDto addressRequestDto)
			throws ResourceFoundException;

	public Map<String, Object> addressCreate(AddressRequestDto addressRequestDto) throws ResourceFoundException;

	public Map<String, Object> addressUpdate(AddressRequestDto addressRequestDto) throws ResourceFoundException;

	public Map<String, Object> addressDelete(AddressRequestDto addressRequestDto) throws ResourceFoundException;
}
