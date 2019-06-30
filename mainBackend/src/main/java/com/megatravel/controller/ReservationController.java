package com.megatravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.converter.ReservationConverter;
import com.megatravel.dto.ReservationDTO;
import com.megatravel.model.Cancellation;
import com.megatravel.model.EndUser;
import com.megatravel.model.Reservation;
import com.megatravel.model.ReservationStatus;
import com.megatravel.security.SecurityService;
import com.megatravel.service.ReservationService;
import com.megatravel.service.UserService;

@RestController
@RequestMapping(value = "reservation")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private UserService userService;
		
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/cancel/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> cancel(@PathVariable("id") String id) {
		
		Long rid = Long.parseLong(id);
		Reservation reservation = reservationService.getReservationById(rid);
		
		Cancellation cancel =reservation.getAccommodation().getCancellation();
		
		if (cancel.isAvailable() == false) {
			return new ResponseEntity<String>("cancellation is not allowed!", HttpStatus.BAD_REQUEST);
		}
		
		reservation.setStatus(ReservationStatus.CANCELED);
		
		reservationService.save(reservation);
		
		return ResponseEntity.ok("Canceled");
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createReservation(@RequestBody ReservationDTO reservationDTO) {
		
		
		String username = securityService.findLoggedInUsername();
		
		
		Reservation reservation = ReservationConverter.toEntity(reservationDTO);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		

		
		System.out.println("JA SAM 1: " + username);
		
		EndUser client = userService.findEndUserByUsername(username);
		
		reservation.setStatus(ReservationStatus.ON_HOLD); //nije odobrena
		
		//nakon sto odobri agent promeni from i till date u accommodation
			
		if(reservation.getFromDate() == null) {
			return new ResponseEntity<String>("Please select from date", HttpStatus.BAD_REQUEST);
		}
		
		if(reservation.getTillDate() == null) {
			return new ResponseEntity<String>("Please select till date", HttpStatus.BAD_REQUEST);
		}
		
		if((reservation.getFromDate().compareTo(reservation.getAccommodation().getFromDate()) > 0) && (reservation.getFromDate().compareTo(reservation.getAccommodation().getTillDate()) < 0)) {
			return new ResponseEntity<String>("Accommodation is not available in that period", HttpStatus.BAD_REQUEST);
		}
		
		if((reservation.getTillDate().compareTo(reservation.getAccommodation().getFromDate()) > 0) && (reservation.getTillDate().compareTo(reservation.getAccommodation().getTillDate()) < 0)) {
			return new ResponseEntity<String>("Accommodation is not available in that period", HttpStatus.BAD_REQUEST);
		}
		
		if(reservation.getFromDate().compareTo(reservation.getTillDate()) > 0){
			return new ResponseEntity<String>("Not allowed! from date >> till date", HttpStatus.BAD_REQUEST);
		}
		
		reservation.getAccommodation().setAvailable(false);

		client.getReservations().add(reservation);
		
		reservationService.save(reservation);
		
		return ResponseEntity.ok("Success!");
	}
	

}
