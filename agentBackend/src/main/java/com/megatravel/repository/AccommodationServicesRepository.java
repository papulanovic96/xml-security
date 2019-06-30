package com.megatravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.model.AdditionalServices;


public interface AccommodationServicesRepository extends JpaRepository<AdditionalServices, Long> {

}
