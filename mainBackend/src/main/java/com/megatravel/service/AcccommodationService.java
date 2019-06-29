package com.megatravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.model.Accommodation;
import com.megatravel.repository.AccommodationRepository;

@Service
public class AcccommodationService {
	
	@Autowired
	private AccommodationRepository accommodationRepository;

	public List<Accommodation> findAllAvailable() {
		return accommodationRepository.findAllAvailable();
	}
	
	public List<Accommodation> findAll() {
		return accommodationRepository.findAllAvailable();
	}
	
	public Accommodation getAccommodationById(Long id) {
		return accommodationRepository.findById(id).orElse(null);
	}


}
