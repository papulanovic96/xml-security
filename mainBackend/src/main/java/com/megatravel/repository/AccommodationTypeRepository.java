package com.megatravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megatravel.model.AccommodationType;

@Repository
public interface AccommodationTypeRepository extends JpaRepository<AccommodationType, Long> {
	
	AccommodationType findByName(String name);

}
