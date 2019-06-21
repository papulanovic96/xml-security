package com.megatravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.model.AccommodationCategory;

public interface AccommodationCategoryRepository extends JpaRepository<AccommodationCategory, Long> {

	AccommodationCategory findByName(String name);
	
}
