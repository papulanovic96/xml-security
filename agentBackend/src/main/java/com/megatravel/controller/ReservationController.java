package com.megatravel.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.converter.ReservationConverter;
import com.megatravel.dto.response.ResponseReservation;
import com.megatravel.dto.soap.CudReservationResponse;
import com.megatravel.dto.soap.UpdateReservationRequest;
import com.megatravel.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ResponseReservation>> get(){
		return ResponseEntity.ok(ReservationConverter.fromEntityList(reservationService.findAll(), (reservation -> ReservationConverter.toResponseFromEntity(reservation))));
	}
	
	@RequestMapping(value = "/approve", method = RequestMethod.PUT, produces =  MediaType.APPLICATION_JSON)
	public ResponseEntity<CudReservationResponse> approve(@RequestBody UpdateReservationRequest request){
		reservationService.approve(request);
		return ResponseEntity.ok(new CudReservationResponse("Reservation with id '" + request.getId() + "' has been approved!"));
	}
	
	@RequestMapping(value = "/reject", method = RequestMethod.PUT, produces =  MediaType.APPLICATION_JSON)
	public ResponseEntity<CudReservationResponse> reject(@RequestBody UpdateReservationRequest request){
		reservationService.reject(request);
		return ResponseEntity.ok(new CudReservationResponse("Reservation with id '" + request.getId() + "' has been rejected!"));
	}
	
}
