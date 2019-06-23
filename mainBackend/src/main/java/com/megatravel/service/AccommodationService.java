package com.megatravel.service;

import org.springframework.stereotype.Service;

import com.megatravel.model.Accommodation;
import com.megatravel.repository.AccommodationRepository;

@Service
public class AccommodationService {

	private AccommodationRepository accommodationRepository;
	
	public Accommodation findAccommodation(String name) {
		return accommodationRepository.findByName(name);
	}
	
}
