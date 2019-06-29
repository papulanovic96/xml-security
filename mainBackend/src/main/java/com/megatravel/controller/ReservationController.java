package com.megatravel.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.dto.ReservationDTO;
import com.megatravel.model.Cancelation;
import com.megatravel.model.EndUser;
import com.megatravel.model.Reservation;
import com.megatravel.model.ReservationStatus;
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
	
	
	private ModelMapper modelMapper;
	
	@RequestMapping(value = "/cancel/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> cancel(@PathVariable("id") String id) {
		
		Long rid = Long.parseLong(id);
		Reservation reservation = reservationService.getReservationById(rid);
		
		Cancelation cancel =reservation.getAccommodation().getCancelation();
		
		if (cancel.isAvailable() == false) {
			return ResponseEntity.badRequest().build();
		}
		
		reservation.setStatus(ReservationStatus.CANCELED);
		
		reservationService.save(reservation);
		
		return ResponseEntity.ok("Canceled");
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createReservation(@RequestBody ReservationDTO reservationDTO) {
				
		Reservation reservation = convertToEntity(reservationDTO);
		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		
//		String signed;
//		
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//			signed = authentication.getName();
//		} else {
//			return null;
//		}
		
		EndUser client = userService.findEndUserByUsername("rabbit19");
		
		reservation.setStatus(ReservationStatus.ON_HOLD); //nije odobrena
			
		if(reservation.getFromDate() == null) {
			return new ResponseEntity<String>("Please select from date", HttpStatus.BAD_REQUEST);
		}
		
		if(reservation.getTillDate() == null) {
			return new ResponseEntity<String>("Please select till date", HttpStatus.BAD_REQUEST);
		}
		
		if(reservation.getFromDate().compareTo(reservation.getAccommodation().getTillDate()) > 0) {
			return new ResponseEntity<String>("Accommodation is not available in that period", HttpStatus.BAD_REQUEST);
		}
		
		reservation.getAccommodation().setAvailable(false);

		client.getReservations().add(reservation);
		
		reservationService.save(reservation);
		
		return ResponseEntity.ok("Success!");
	}
	
	private ReservationDTO convertToDto(Reservation reservation) {
		ReservationDTO reservationDTO = modelMapper.map(reservation, ReservationDTO.class);
		return reservationDTO;
	}
	
	private Reservation convertToEntity(ReservationDTO reservationDTO) {
		Reservation reservation = modelMapper.map(reservationDTO, Reservation.class);
	   		
		if(reservationService.getReservationById(reservationDTO.getId()) != null) {
			Reservation old = reservationService.getReservationById(reservationDTO.getId());
			reservation.setId(old.getId());
		}
		
	  
	    return reservation;
	}
	

}
