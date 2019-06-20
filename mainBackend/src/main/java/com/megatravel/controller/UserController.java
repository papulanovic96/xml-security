package com.megatravel.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.AccommodationCategory;
import com.megatravel.model.EndUser;
import com.megatravel.model.Role;
import com.megatravel.repository.AccommodationCategoryRepository;
import com.megatravel.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private AccommodationCategoryRepository acc;
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public AccommodationCategory test() {
//		
//		return acc.findByName("1*");
//	}
	
	@RequestMapping(value = "/findAllEndUsers", method = RequestMethod.GET)
	public List<EndUser> findAll() {
		return userService.findEndUsers();
	}
	
	@RequestMapping(value = "/setUserRole/{username}", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public List<EndUser> setl(@RequestBody Role role, @PathVariable("username") String username) {
		
		EndUser e = userService.findEndUser(username);
		
		e.getRoles().add(role);
		
		userService.save(e);
		
		return userService.findEndUsers();
	}
	
	

	@RequestMapping(value = "/findEndUser", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public EndUser findEndUser(@RequestBody String username) {
		return userService.findEndUser(username);	
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
	public EndUser save(@RequestBody EndUser eu) {
		userService.save(eu);
		return eu;
	}
	

}
