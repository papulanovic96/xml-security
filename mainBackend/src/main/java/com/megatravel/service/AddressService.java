package com.megatravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.model.Address;
import com.megatravel.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository aRepository;

	public Address save(Address adresa) {
		return aRepository.save(adresa);
	}
	
	public List<Address> findAll(){
		return aRepository.findAll();
	}
}
