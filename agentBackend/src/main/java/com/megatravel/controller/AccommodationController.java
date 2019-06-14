package com.megatravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.Accommodation;
import com.megatravel.service.AccommodationService;

@RestController
@RequestMapping("/accomodation")
public class AccommodationController {
	
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

}
