package com.megatravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.model.Reservation;

public interface ReservationRepistory extends JpaRepository<Reservation, Long>{

}
