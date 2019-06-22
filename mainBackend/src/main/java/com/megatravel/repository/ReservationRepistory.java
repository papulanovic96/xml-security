package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.model.EndUser;
import com.megatravel.model.Reservation;

public interface ReservationRepistory extends JpaRepository<Reservation, Long>{

	List<Reservation> findByReservedBy(EndUser eu);
	
}
