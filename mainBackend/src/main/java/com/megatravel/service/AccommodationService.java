package com.megatravel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.megatravel.model.Accommodation;
import com.megatravel.model.AccommodationCategory;
import com.megatravel.model.AccommodationType;
import com.megatravel.repository.AccommodationRepository;

@Service
public class AccommodationService {

	private AccommodationRepository accommodationRepository;
	
	public Accommodation findAccommodation(String name) {
		return accommodationRepository.findByName(name);
	}
	
	public List<Accommodation> findByCategory(AccommodationCategory category){
		return accommodationRepository.findByCategory(category);
	}
	
	public List<Accommodation> findByType(AccommodationType type){
		return accommodationRepository.findByType(type);
	}

	public void save(Accommodation accommodation) {
		accommodationRepository.save(accommodation);
	}
}
