package com.megatravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.megatravel.model.Accommodation;
import com.megatravel.model.Message;
import com.megatravel.service.AccommodationService;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	@Autowired
	private AccommodationService accommodationService;
	
	@RequestMapping(value ="/getByCategory/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getByCategory(@PathVariable int id){
		
		Accommodation accommodation = accommodationService.findByCategory(id);
		if(accommodation == null) {
			return new ResponseEntity<String>("not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	

	@RequestMapping(value="/getMessage")
	public Message get() {
	
		Message test = restTemplate.getForObject("http://message-service/messages/test", Message.class);
		return test;
		
	}
	@RequestMapping(value="/addAccommodation")
	public String add() {
		
		String test = restTemplate.getForObject("http://add-accommodation-service/accommodations/add", String.class);
		return test;
	
	}
}
