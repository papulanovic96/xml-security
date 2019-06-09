package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.model.Accommodation;
import com.megatravel.model.Type;


public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{
	
	List<Accommodation> findAll();
	List<Accommodation> findByCategory(int category);
	List<Accommodation> findByType(Type type);

}
