package com.megatravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megatravel.model.Accommodation;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{

	@Query(value = "SELECT id FROM accommodation WHERE category = ?4", nativeQuery = true)
	Accommodation findByCategory(int category);
}
