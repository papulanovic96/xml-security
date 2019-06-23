package com.megatravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.Accommodation;
import com.megatravel.model.EndUser;
import com.megatravel.model.Message;
import com.megatravel.model.Reservation;
import com.megatravel.model.Role;
import com.megatravel.model.Roles;
import com.megatravel.service.AccommodationService;
import com.megatravel.service.MessageService;
import com.megatravel.service.ReservationService;
import com.megatravel.service.UserService;

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
	
	@Autowired
	private MessageService messageService;
	
	
	@RequestMapping(value = "/findEndUser/{username}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EndUser findEndUser(@PathVariable("username") String username) {
		return userService.findEndUserByUsername(username);	
	}
	
	@RequestMapping(value = "/findAllEndUsers", method = RequestMethod.GET)
	public List<EndUser> test() {
		return userService.findEndUsers();
	}
	
	@RequestMapping(value = "/login/confirm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void confirmLogin(@RequestBody UsernamePasswordAuthenticationToken token) {
	
		Authentication auth =  authenticationManager.authenticate(token);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		System.out.println("JA SAM : "  + authentication.getName());
		
		
		  
	
	}
	
	@RequestMapping(value = "/setUserRole/{username}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EndUser> setRole(@RequestBody Role role, @PathVariable("username") String username) {
		
		EndUser e = userService.findEndUserByUsername(username);
		
		e.getRoles().add(role);
		
		userService.save(e);
		
		return userService.findEndUsers();
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String logout() {
		
		SecurityContextHolder.getContext().setAuthentication(null);
		
		return "You have been signed out.";
	}
		
//	@RequestMapping(value = "/account/reservations", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Reservation>> findMyReservations() {
//		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		
//		String username;
//		
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//		    username = authentication.getName();
//		} else {
//			return null;
//		}
//
//		EndUser client = userService.findEndUserByUsername(username);
//		
//		if (reservationService.findMyReservations(client) == null) 
//			return ResponseEntity.badRequest().body(reservationService.findMyReservations(client));
//		else
//			return ResponseEntity.ok(reservationService.findMyReservations(client));
//	}
	
	@RequestMapping(value = "/inbox", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Message> inbox() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		EndUser currentSigned = userService.findEndUserByUsername(authentication.getName());
		
		return messageService.findMyInbox(currentSigned.getId());
	}
	
//	@RequestMapping(value = "/chatHistory", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<Message> chatHistory(@RequestBody Message message) {
//		return messageService.findChatHistory(message.getAgent().getId(), message.getEndUser().getId());
//	}
	
	
	
	@RequestMapping(value = "/createReservation", method = RequestMethod.POST)
	public ResponseEntity<Reservation> createReservation(@RequestBody Accommodation accommodation) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		EndUser client = userService.findEndUserByUsername(authentication.getName());
		
		if (client == null) {
			return ResponseEntity.badRequest().build();
		}
		
		Reservation reservation = new Reservation();
		
		reservation.setStatus(false); //nije odobrena
		
//		reservation.setReservedBy(client);
		
		accommodation.setAvailable(false);
		
		reservation.setAccomodation(accommodation);
		
		
		
		
		return ResponseEntity.ok(reservation);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<EndUser> save(@RequestBody EndUser client) throws Exception {

		System.out.println(client.getRoles().toString());
		
		for (Role role : client.getRoles()) {
			if (role.getName().equals(Roles.END_USER)) {
				
				userService.save(client);
				return ResponseEntity.ok(client);
			}
		}

		return ResponseEntity.badRequest().build();
	}
	

}
