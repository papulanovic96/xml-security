package com.megatravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.AccommodationType;
import com.megatravel.service.AccommodationTypeService;

@RestController
@RequestMapping("/accommodation-type")
public class AccommodationTypeController {

	@Autowired
	private AccommodationTypeService atService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> newType(@RequestBody AccommodationType aType) {
		List<AccommodationType> listOfTypes = atService.findAll();
		for(AccommodationType at : listOfTypes) {
		if(aType.getName().equalsIgnoreCase(at.getName())) {
			return new ResponseEntity<String>("Type with name: " + at.getName() + " already exists!", HttpStatus.CONFLICT);
		}
	}
		atService.save(aType);
		return new ResponseEntity<String>("Successfully added new type!", HttpStatus.CREATED);

	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> requestMethodName(@PathVariable Long id) {
		AccommodationType newType = atService.findById(id);
		if(newType == null) {
			return new ResponseEntity<String>("Type not found! #404", HttpStatus.NOT_FOUND);
		} else {
			atService.delete(newType);
			return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> findById(@PathVariable Long id) {
			AccommodationType newType = atService.findById(id);
			if(newType == null) {
				return new ResponseEntity<String>("Type not found!", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<String>("Type with id: " + newType.getId() + " found!", HttpStatus.OK);
			}
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccommodationType>> findAll() {
		List<AccommodationType> newList = atService.findAll();
		if(newList == null) {
			return new ResponseEntity<List<AccommodationType>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AccommodationType>>(newList, HttpStatus.OK);
	}


	@RequestMapping(value = "/modify/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> modifyType(@PathVariable Long id , @RequestBody AccommodationType aType){
		aType.setId(id);
		List<AccommodationType> listOfTypes = atService.findAll();
		
			for(AccommodationType at : listOfTypes) {
				if(aType.getName().equalsIgnoreCase(at.getName())) {
					return new ResponseEntity<String>("Type with name: " + at.getName() + " already exists!", HttpStatus.CONFLICT);
				}
			}
			boolean successed = atService.modifyAccommodationType(aType);
			if(successed) {
				return new ResponseEntity<String>("Type successfully modified!", HttpStatus.OK);
			}
		return new ResponseEntity<String>("Failed to modify unexisting type!", HttpStatus.NOT_FOUND);
	}
}