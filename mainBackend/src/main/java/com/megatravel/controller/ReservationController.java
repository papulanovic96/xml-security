package com.megatravel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.service.ReservationService;

@RestController
@RequestMapping(value = "reservation")
public class ReservationController {
	
	private ReservationService reservationService;
	
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String create() {
		
		return "reservation created";
	}
	
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public String cancel() {
		
		return "reservation canceled";
	}
	

}
