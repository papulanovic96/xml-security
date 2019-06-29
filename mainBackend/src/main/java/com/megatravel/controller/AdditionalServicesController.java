package com.megatravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.AdditionalServices;
import com.megatravel.service.AdditionalServicesService;

@RestController
@RequestMapping("/additional-services")
@ComponentScan(basePackages = "com.megatravel.controller")
public class AdditionalServicesController {
	
	@Autowired
	private AdditionalServicesService asService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> newType(@RequestBody AdditionalServices aService) {
		List<AdditionalServices> listOfServices = asService.findAll();
		for(AdditionalServices as : listOfServices) {
		if(aService.getName().equalsIgnoreCase(as.getName())) {
			return new ResponseEntity<String>("Additional service with name: " + as.getName() + " already exists!", HttpStatus.CONFLICT);
		}
	}
		asService.save(aService);
		return new ResponseEntity<String>("Successfully added new additional service!", HttpStatus.CREATED);

	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> requestMethodName(@PathVariable Long id) {
		AdditionalServices newService = asService.findById(id);
		if(newService == null) {
			return new ResponseEntity<String>("Additional service not found! #404", HttpStatus.NOT_FOUND);
		} else {
			asService.delete(newService);
			return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> findById(@PathVariable Long id) {
		AdditionalServices newService = asService.findById(id);
			if(newService == null) {
				return new ResponseEntity<String>("Additional service not found!", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<String>("Additional service with id: " + newService.getId() + " found!", HttpStatus.OK);
			}
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdditionalServices>> findAll() {
		List<AdditionalServices> newServiceList = asService.findAll();
		if(newServiceList == null) {
			return new ResponseEntity<List<AdditionalServices>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AdditionalServices>>(newServiceList, HttpStatus.OK);
	}


	@RequestMapping(value = "/modify/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> modifyType(@PathVariable Long id , @RequestBody AdditionalServices aService){
		aService.setId(id);
		List<AdditionalServices> listOfServices = asService.findAll();
		
			for(AdditionalServices as : listOfServices) {
				if(aService.getName().equalsIgnoreCase(as.getName())) {
					return new ResponseEntity<String>("Additional service with name: " + as.getName() + " already exists!", HttpStatus.CONFLICT);
				}
			}
			boolean successed = asService.modifyAdditionalServices(aService);
			if(successed) {
				return new ResponseEntity<String>("Additional service successfully modified!", HttpStatus.OK);
			}
		return new ResponseEntity<String>("Failed to modify unexisting additional service!", HttpStatus.NOT_FOUND);
	}
}