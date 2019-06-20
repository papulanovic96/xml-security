package com.megatravel.addaccommodationervice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.addaccommodationervice.model.Accommodation;


@RestController
@RequestMapping("/accommodations")
public class AddAccommodationResource {


	@RequestMapping("/add")
	public String add(Accommodation accommodation) {
		
		return "NAPRAVLJEN";
	}
}
