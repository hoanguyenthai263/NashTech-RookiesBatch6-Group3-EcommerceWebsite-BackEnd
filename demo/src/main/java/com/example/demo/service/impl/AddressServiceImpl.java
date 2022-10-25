package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.response.AddressResponseDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceFoundException;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	private final AddressRepository addressRepository;
	private final AddressMapper addressMapper;

	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
		this.addressRepository = addressRepository;
		this.addressMapper = addressMapper;
	}

	private Map<String, Object> createAddressListWithUser(List<Address> list) {
		Map<String, Object> wrapper = new HashMap<>();
		Map<String, Object> dataWrapper = new HashMap<>();
		wrapper.put("data", dataWrapper);
		List<AddressResponseDto> addressWarrper = new ArrayList<>();
		dataWrapper.put("address", addressWarrper);
		for (Address address : list) {
			if (address.getStatus().equals(1)) {
				AddressResponseDto addressResponseDto = addressMapper.addressToResponse(address);
				addressWarrper.add(addressResponseDto);
			}
		}
		return wrapper;
	}

	@Override
	public Map<String, Object> addressListWithUser(User user) throws ResourceFoundException {
		List<Address> addressList = addressRepository.findByUserId(user);
		if (addressList.isEmpty()) {
			throw new ResourceFoundException("Address not found");
		}
		return createAddressListWithUser(addressList);
	}

}
