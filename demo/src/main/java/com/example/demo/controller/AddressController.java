package com.example.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.AddressService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
	private AddressService addressService;
	private UserService userService;
	private UserMapper usermapper;

	@Autowired
	public AddressController(AddressService addressService, UserService userService, UserMapper usermapper) {
		this.addressService = addressService;
		this.userService = userService;
		this.usermapper = usermapper;
	}

	@GetMapping("/user")
	public Map<String, Object> searchWithUser(@Valid @RequestBody UserRequestDto userRequestDto)
			throws ResourceFoundException {
		Map<String, UserResponseDto> userResponseDto = userService.userWithId(userRequestDto);
		User user = usermapper.responseToRole(userResponseDto.get("data"));
		return addressService.addressListWithUser(user);
	}
}
