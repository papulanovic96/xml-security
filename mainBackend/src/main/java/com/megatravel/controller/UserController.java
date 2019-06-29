package com.megatravel.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.dto.ReservationDTO;
import com.megatravel.dto.RoleDTO;
import com.megatravel.dto.UserDTO;
import com.megatravel.model.EndUser;
import com.megatravel.model.Reservation;
import com.megatravel.model.Role;
import com.megatravel.model.Roles;
import com.megatravel.service.AccommodationService;
import com.megatravel.service.ReservationService;
import com.megatravel.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserDetailsService userDetails;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private AccommodationService accommodationService;
	
	@Autowired
	private ModelMapper modelMapper;
	
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
	public void confirmLogin(@RequestBody String username) {
	
		EndUser client = userService.findEndUserByUsername(username);
		
		UserDetails ud = userDetails.loadUserByUsername(username);
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(ud, client.getPassword(), ud.getAuthorities());

		Authentication auth =  authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        
        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
	        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	        
	    
	        System.out.println("ULOGOVAN SI !!!!!!!!!!");
	    }
        
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
	
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public ResponseEntity<List<ReservationDTO>> findMyReservations() {
		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		
//		String signed;
//		
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//			signed = authentication.getName();
//		} else {
//			return ResponseEntity.badRequest().build();
//		}

		EndUser client = userService.findEndUserByUsername("rabbit19");

		List<Reservation> reservations = reservationService.findMyReservations(client.getId());

		List<ReservationDTO> reservationsDto = new ArrayList<ReservationDTO>();
		

		for (Reservation reservation : reservations) {
			reservationsDto.add(convertToDto(reservation));
		}
		
		if (reservations == null) 
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.ok(reservationsDto);
	}
	
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> save(@RequestBody UserDTO client) throws Exception {
		
		EndUser eu = convertToEntity(client);
	
		System.out.println("MOJA   : : : : : : " + eu.getRoles().get(0));
		
		for (RoleDTO role : client.getRoles()) {
			if (role.getName().equals(Roles.END_USER)) {
				
				userService.save(eu);
				
				return new ResponseEntity<String>("Account successfully created!", HttpStatus.CREATED);
			}
		}

		return new ResponseEntity<String>("Unauthorized request!", HttpStatus.UNAUTHORIZED);
	}
	
	private ReservationDTO convertToDto(Reservation reservation) {
		ReservationDTO reservationDTO = modelMapper.map(reservation, ReservationDTO.class);
		return reservationDTO;
	}
	
	private Reservation convertToEntity(ReservationDTO reservationDTO) {
		Reservation reservation = modelMapper.map(reservationDTO, Reservation.class);
	   		
		if(reservationService.getReservationById(reservationDTO.getId()) != null) {
			Reservation old = reservationService.getReservationById(reservationDTO.getId());
			reservation.setId(old.getId());
		}
		
	  
	    return reservation;
	}
	
	private EndUser convertToEntity(UserDTO user) {
		EndUser client = modelMapper.map(user, EndUser.class);
		
		if(userService.findEndUserByUsername(user.getUsername()) != null) {
			EndUser old = userService.findEndUserByUsername(user.getUsername());
			client.setId(user.getId());
		}
		
		return client;
		
	}

}
