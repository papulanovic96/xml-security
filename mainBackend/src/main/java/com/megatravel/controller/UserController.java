package com.megatravel.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.EndUser;
import com.megatravel.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String test() {
		
		return "rest test";
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<EndUser> findAll() {
		return userService.findEndUsers();
	}

	@RequestMapping(value = "/exist", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public EndUser exist(@RequestBody EndUser user) {
		return userService.findEndUser(user.getUsername());	
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {
		
		return "logout test";
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account() {
		
		return "account test";
	}
	
	@RequestMapping(value = "/inbox", method = RequestMethod.GET)
	public String inbox() {
		
		return "inbox test";
	}
	
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public String getReservations() {
		
		return "my reservations test";
	}
	
	@RequestMapping(value = "/createReservation", method = RequestMethod.POST)
	public String createReservation() {
		
		return "create reservation test";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON )
	public List<EndUser> save(@RequestBody EndUser eu) {
		userService.save(eu);
		return userService.findEndUsers();
	}
	

}
