package com.megatravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.model.AccommodationType;

public interface AccommodationTypeRepository extends JpaRepository<AccommodationType, Long> {
	
	AccommodationType findByName(String name);

}
