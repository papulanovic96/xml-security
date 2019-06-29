package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megatravel.model.Reservation;

@Repository
public interface ReservationRepistory extends JpaRepository<Reservation, Long>{
	
	@Query(value = "select * from "
				 + "booking.reservation join booking.user_reservations on "
				 + "booking.reservation.id = booking.user_reservations.reservations_id where "
				 + "booking.user_reservations.end_user_id = ?1", nativeQuery = true)
	List<Reservation> findMyReservations(Long id);
	
}
