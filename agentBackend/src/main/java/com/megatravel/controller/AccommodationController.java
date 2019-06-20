package com.megatravel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import javax.ws.rs.core.MediaType;
import com.megatravel.model.Accommodation;
import com.megatravel.model.AccommodationCategory;
import com.megatravel.model.Message;
import com.megatravel.service.AccommodationService;


@RestController
@RequestMapping("/accommodation")
public class AccommodationController {
	
	
	@Autowired
	private RestTemplate restTemplate;
	

	@Autowired
	private AccommodationService accommodationService;
		
	@RequestMapping(value ="/getByCategory/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getByCategory(@PathVariable int id){
		
		AccommodationCategory accCateg = new AccommodationCategory();
		accCateg.setId(id);
		List<Accommodation> accommodations = accommodationService.findByCategory(accCateg);
		if(accommodations.size() == 0) {
			return new ResponseEntity<String>("Not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	

	@RequestMapping(value="/getMessage")
	public Message get() {
	
		Message test = restTemplate.getForObject("http://message-service/messages/test", Message.class);
		return test;
		
	}
		
	@RequestMapping(value="/addAccommodation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public void add(@RequestBody Accommodation accommodation) {
		
		accommodationService.save(accommodation);

	}
	@RequestMapping(value="/changeAvalibility", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public void changeAvalibility(@RequestBody Accommodation accommodation, boolean available) {
		

	}
	
	
}
