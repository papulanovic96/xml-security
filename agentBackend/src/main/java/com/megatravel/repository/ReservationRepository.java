package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.megatravel.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	

	@Query(value = "select * from agentLocalBase.reservation where accommodation_id = ?1", 
			nativeQuery = true)
	List<Reservation> getReservations(long accId);

}
