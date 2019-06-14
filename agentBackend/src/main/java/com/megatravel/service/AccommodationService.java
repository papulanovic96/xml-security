package com.megatravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.model.Accommodation;
import com.megatravel.repository.AccommodationRepository;

@Service
public class AccommodationService {

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	public Accommodation findByCategory(int category) {
		return this.accommodationRepository.findByCategory(category);
	}
}
