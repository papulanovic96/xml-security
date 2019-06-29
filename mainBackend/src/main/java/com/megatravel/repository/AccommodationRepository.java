package com.megatravel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megatravel.model.Accommodation;
import com.megatravel.model.AccommodationCategory;
import com.megatravel.model.AccommodationType;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{
	
	@Query(value = "select * from booking.accommodation where booking.accommodation.available = '1'", nativeQuery = true)
	List<Accommodation> findAllAvailable();
	
	List<Accommodation> findAll();
	
	List<Accommodation> findByCategory(AccommodationCategory category);
	
	List<Accommodation> findByType(AccommodationType type);
	
	Accommodation findByName(String name);
	
	
	

}
