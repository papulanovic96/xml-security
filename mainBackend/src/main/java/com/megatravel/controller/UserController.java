package com.megatravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.EndUser;
import com.megatravel.model.Reservation;
import com.megatravel.model.Role;
import com.megatravel.model.Roles;
import com.megatravel.service.AccommodationService;
import com.megatravel.service.ReservationService;
import com.megatravel.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private AccommodationService accommodationService;
	
	
	@RequestMapping(value = "/findEndUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EndUser findEndUser(@RequestBody String clientUN) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		System.out.println("JA SAM : "  + authentication.getName());
		
		if (userService.findEndUserByUsername(clientUN) != null) 
			return userService.findEndUserByUsername(clientUN);
		else 
			return null;
		
		
	}
	@RequestMapping(value = "/findAllEndUsers", method = RequestMethod.GET)
	public List<EndUser> test() {
		return userService.findEndUsers();
	}
	
	@RequestMapping(value = "/login/confirm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void confirmLogin(@RequestBody UserDetails signedIn) {
	
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(signedIn, signedIn.getPassword(), signedIn.getAuthorities());

		Authentication auth =  authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> logout() {
		
		SecurityContextHolder.getContext().setAuthentication(null);
		
		return new ResponseEntity<String>("You have successfully signed out.", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/setRole/{username}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EndUser> setRole(@RequestBody Role role, @PathVariable("username") String username) {
		
		EndUser e = userService.findEndUserByUsername(username);
		
		e.getRoles().add(role);
		
		userService.save(e);
		
		return userService.findEndUsers();
	}
	
	@RequestMapping(value = "/reservations", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reservation>> findMyReservations() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String signed;
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			signed = authentication.getName();
		} else {
			return ResponseEntity.badRequest().build();
		}

		EndUser client = userService.findEndUserByUsername(signed);

		List<Reservation> reservations = reservationService.findMyReservations(client.getId());
		
		if (reservations == null) 
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.ok(reservations);
	}
	
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> save(@RequestBody EndUser client) throws Exception {

		for (Role role : client.getRoles()) {
			if (role.getName().equals(Roles.END_USER)) {
				
				userService.save(client);
				
				return new ResponseEntity<String>("Account successfully created!", HttpStatus.CREATED);
			}
		}

		return new ResponseEntity<String>("Unauthorized request!", HttpStatus.UNAUTHORIZED);
	}
	

}
