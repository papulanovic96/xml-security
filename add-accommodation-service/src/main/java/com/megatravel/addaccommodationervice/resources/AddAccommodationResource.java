package com.megatravel.addaccommodationervice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accommodations")
public class AddAccommodationResource {

  
	@RequestMapping("/add")
	public String add() {
		return "TEST ADD";
	}

}
