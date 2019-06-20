package com.megatravel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.megatravel.model.Accommodation;
import com.megatravel.model.AccommodationCategory;
import com.megatravel.repository.AccommodationRepository;

@Service
public class AccommodationService {
	
	private AccommodationRepository accommodationRepository;
	public List<Accommodation> findByCategory(AccommodationCategory categ) {
		return accommodationRepository.findByCategory(categ);
	}
	public void save(Accommodation acc) {
		accommodationRepository.save(acc);
	}
}
