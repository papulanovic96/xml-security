package com.megatravel.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.converter.AccommodationConverter;
import com.megatravel.dto.response.ResponseAccommodation;
import com.megatravel.service.AccommodationService;


@RestController
@RequestMapping("/accommodations")
public class AccommodationController {
		
	@Autowired
	private AccommodationService accommodationService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ResponseAccommodation>> findAll() {
		return ResponseEntity.ok(AccommodationConverter.fromEntityList( accommodationService.findAll(), acc -> AccommodationConverter.toResponseFromEntity((acc))));
	}
		
}
