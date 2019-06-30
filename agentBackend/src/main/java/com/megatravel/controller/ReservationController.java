package com.megatravel.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.dto.ReservationDTO;
import com.megatravel.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	
	@PostMapping(value = "/getReservations", produces =  MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ReservationDTO>> getReservationsByAcc(@RequestBody long id){
		
		List<ReservationDTO> reservations = reservationService.getReservationsByAcc(id);
		return new ResponseEntity<>(reservations, HttpStatus.OK);
		
	}
}
