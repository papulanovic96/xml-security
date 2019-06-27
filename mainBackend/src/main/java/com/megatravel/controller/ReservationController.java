package com.megatravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.Accommodation;
import com.megatravel.model.EndUser;
import com.megatravel.model.Reservation;
import com.megatravel.service.ReservationService;
import com.megatravel.service.UserService;

@RestController
@RequestMapping(value = "reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String create() {
		
		return "reservation created";
	}
	
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public String cancel() {
		
		return "reservation canceled";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Reservation> createReservation(@RequestBody Accommodation accommodation) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String signed;
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			signed = authentication.getName();
		} else {
			return null;
		}
		
		EndUser client = userService.findEndUserByUsername(signed);
		
		Reservation reservation = new Reservation();
		
		reservation.setStatus(false); //nije odobrena
			
		accommodation.setAvailable(false);
		
		reservation.setAccomodation(accommodation);
		
		reservation.setFromDate(accommodation.getFromDate());
		reservation.setTillDate(accommodation.getTillDate());
		
		client.getReservations().add(reservation);
		
		reservationService.save(reservation);
		
		return ResponseEntity.ok(reservation);
	}
	

}
