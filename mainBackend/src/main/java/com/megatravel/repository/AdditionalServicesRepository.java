package com.megatravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megatravel.model.AdditionalServices;

@Repository
public interface AdditionalServicesRepository extends JpaRepository<AdditionalServices, Long>{

	@Modifying
	@Query(value = "UPDATE additional_services SET name = ?2 WHERE id = ?1", nativeQuery = true)
	void modifyAS(Long id, String name);
	
	AdditionalServices findByName(String name);
}
