package com.megatravel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.dto.ReservationDTO;
import com.megatravel.model.Reservation;
import com.megatravel.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	
	
	public List<ReservationDTO> getReservationsByAcc(long id) {
		List<Reservation> reservations = reservationRepository.getReservations(id);
		List<ReservationDTO> reservationsDTO = new ArrayList<>();
		
		for(Reservation r : reservations) {
			reservationsDTO.add(new ReservationDTO(r));
		}
		
		return reservationsDTO;
	}

}
