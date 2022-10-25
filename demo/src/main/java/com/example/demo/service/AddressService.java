package com.example.demo.service;

import java.util.Map;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceFoundException;

public interface AddressService {
	public Map<String, Object> addressListWithUser(User user) throws ResourceFoundException;
}
