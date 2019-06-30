package com.megatravel.converter;

import com.megatravel.dto.ReservationDTO;
import com.megatravel.model.Accommodation;
import com.megatravel.model.Reservation;

public class ReservationConverter extends AbstractConverter {
	
	public static ReservationDTO fromEntity(Reservation r) { 
		ReservationDTO resDTO = new ReservationDTO();
		
		resDTO.setId(r.getId());
		resDTO.setAccommodation(AccommodationConverter.fromEntity(r.getAccommodation()));
		resDTO.setFromDate(r.getFromDate());
		resDTO.setTillDate(r.getTillDate());
		resDTO.setStatus(r.getStatus());
		
		return resDTO;
	}
	
	public static Reservation toEntity(ReservationDTO rdto) {
		
		Reservation res = new Reservation();
		
		res.setId(rdto.getId());
		res.setAccommodation(AccommodationConverter.toEntity(rdto.getAccommodation()));
		res.setFromDate(rdto.getFromDate());
		res.setTillDate(rdto.getTillDate());
		res.setStatus(rdto.getStatus());
		
		
		
		return res;
		
	}

}
