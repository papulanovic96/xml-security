package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.megatravel.model.Accommodation;
import com.megatravel.model.AccommodationCategory;
import com.megatravel.model.AccommodationType;
import com.megatravel.model.AdditionalServices;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long>{

	List<Accommodation> findAll();
	List<Accommodation> findByCategory(AccommodationCategory category);
	List<Accommodation> findByType(AccommodationType type);
	Accommodation findOneById(long accId);
	
	@Query(value = "select * from agentlocalbase.additional_services", nativeQuery = true)
	List<AdditionalServices> getAllServices();
	//umesto ovoga napravi AdditionalServiceRepository pa idi findAll()
}
