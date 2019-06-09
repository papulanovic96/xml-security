package com.megatravel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.service.AcccommodationService;

@RestController
@RequestMapping(value = "accommodation")
public class AccommodationController {
	
	private AcccommodationService acccommodationService;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll() {
		
		return "list of accommodations";
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add() {
		
		return "accommodation has been added to your reservation";
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove() {
		
		return "accommodation has been removed from your reservation";
		
	}
	

}
