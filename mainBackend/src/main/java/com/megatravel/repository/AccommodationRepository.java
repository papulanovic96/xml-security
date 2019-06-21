package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.model.Accommodation;
import com.megatravel.model.AccommodationCategory;
import com.megatravel.model.AccommodationType;



public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{
	
	List<Accommodation> findAll();
	
	List<Accommodation> findByCategory(AccommodationCategory category);
	
	List<Accommodation> findByType(AccommodationType type);

}
