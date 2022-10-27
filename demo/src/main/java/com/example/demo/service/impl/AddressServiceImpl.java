package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.AddressRequestDto;
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

	private Map<String, AddressResponseDto> createAddressWithId(Address address) {
		Map<String, AddressResponseDto> wrapper = new HashMap<>();
		AddressResponseDto addressResponseDto = addressMapper.addressToResponse(address);
		wrapper.put("data", addressResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, AddressResponseDto> addressWithId(AddressRequestDto addressRequestDto)
			throws ResourceFoundException {
		Optional<Address> addressOptional = addressRepository.findById(addressRequestDto.getId());
		if (addressOptional.isEmpty()) {
			throw new ResourceFoundException("Address not found");
		}
		Address address = addressOptional.get();
		return createAddressWithId(address);
	}

	private Map<String, Object> createAddressCreate(Address address) {
		Map<String, Object> wrapper = new HashMap<>();
		AddressResponseDto addressResponseDto = addressMapper.addressToResponse(address);
		wrapper.put("data", addressResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, Object> addressCreate(AddressRequestDto addressRequestDto) throws ResourceFoundException {
		List<Address> addressList = addressRepository.findByUserId(addressRequestDto.getUserId());
		for (Address address : addressList) {
			if (address.getStreetAddress().equals(addressMapper.requestToAddress(addressRequestDto).getStreetAddress())
					&& address.getCity().equals(addressMapper.requestToAddress(addressRequestDto).getCity())
					&& address.getDistrict().equals(addressMapper.requestToAddress(addressRequestDto).getDistrict())
					&& address.getWard().equals(addressMapper.requestToAddress(addressRequestDto).getWard()))
				throw new ResourceFoundException("Address already in use");

		}
		Address address = addressMapper.requestToAddress(addressRequestDto);
		addressRepository.save(address);
		return createAddressCreate(address);
	}

	private Map<String, Object> createAddressUpdate(Address address) {
		Map<String, Object> wrapper = new HashMap<>();
		AddressResponseDto addressResponseDto = addressMapper.addressToResponse(address);
		wrapper.put("data", addressResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, Object> addressUpdate(AddressRequestDto addressRequestDto) throws ResourceFoundException {
		Optional<Address> addressOptional = addressRepository.findById(addressRequestDto.getId());
		if (addressOptional.isEmpty()) {
			throw new ResourceFoundException("Address not found");
		}
		Integer statusOptional = addressOptional.get().getStatus();
		if (statusOptional.equals(0)) {
			throw new ResourceFoundException("Address not found");
		}
		Address address = addressMapper.requestToAddress(addressRequestDto);
		address.setStatus(statusOptional);
		address.setUserId(addressOptional.get().getUserId());
		addressRepository.save(address);
		return createAddressUpdate(address);
	}

	private Map<String, Object> createAddressDelete(Address address) {
		Map<String, Object> wrapper = new HashMap<>();
		AddressResponseDto addressResponseDto = addressMapper.addressToResponse(address);
		wrapper.put("data", addressResponseDto);
		return wrapper;
	}

	@Override
	public Map<String, Object> addressDelete(AddressRequestDto addressRequestDto) throws ResourceFoundException {
		Optional<Address> addressOptional = addressRepository.findById(addressRequestDto.getId());
		if (addressOptional.isEmpty()) {
			throw new ResourceFoundException("Address not found");
		}
		Integer statusOptional = addressOptional.get().getStatus();
		if (statusOptional.equals(0)) {
			throw new ResourceFoundException("Address not found");
		}
		Address address = addressOptional.get();
		address.setStatus(0);
		addressRepository.save(address);
		return createAddressDelete(address);
	}
}
