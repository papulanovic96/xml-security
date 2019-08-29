package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findAllByAccommodation(long id);
	
}
