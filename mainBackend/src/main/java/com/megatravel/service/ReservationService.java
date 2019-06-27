package com.megatravel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.megatravel.model.EndUser;
import com.megatravel.model.Reservation;
import com.megatravel.repository.ReservationRepistory;

@Service
public class ReservationService {

	private ReservationRepistory reservationRepository;
	
	public List<Reservation> findMyReservations(Long clientId) {
		return reservationRepository.findMyReservations(clientId);
	}

	public void save(Reservation reservation) {
		reservationRepository.saveAndFlush(reservation);
	}
	
}
