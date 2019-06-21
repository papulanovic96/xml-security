package com.megatravel.service;

import org.springframework.stereotype.Service;

import com.megatravel.model.AccommodationType;
import com.megatravel.repository.AccommodationTypeRepository;

@Service
public class AccommodationTypeService {

	private AccommodationTypeRepository atRepository;
	
	public AccommodationType save(AccommodationType aType) {
		return atRepository.save(aType);
	}
}
