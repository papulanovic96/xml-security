package com.megatravel.controller;

import java.util.ArrayList;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.converter.EndUserConverter;
import com.megatravel.converter.ReservationConverter;
import com.megatravel.dto.EndUserDTO;
import com.megatravel.dto.LoginDTO;
import com.megatravel.dto.ReservationDTO;
import com.megatravel.dto.RoleDTO;
import com.megatravel.model.EndUser;
import com.megatravel.model.Reservation;
import com.megatravel.model.Role;
import com.megatravel.model.Roles;
import com.megatravel.security.SecurityService;
import com.megatravel.service.ReservationService;
import com.megatravel.service.UserService;

@RestController
@RequestMapping(value = "user")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class UserController {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private ReservationService reservationService;

	@Autowired
	private AuthenticationManager authenticationManager;
	

	@RequestMapping(value = "/findEndUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EndUserDTO findEndUser(@RequestBody String clientUN) {
	
		if (userService.findEndUserByUsername(clientUN) != null) 
			return EndUserConverter.fromEntity(userService.findEndUserByUsername(clientUN));
		else 
			return null;
		
		
	}
	@RequestMapping(value = "/findAllEndUsers", method = RequestMethod.GET)
	public List<EndUser> test() {
		return userService.findEndUsers();
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void login(@RequestBody LoginDTO user) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
	}
	
	@RequestMapping(value = "/login/get", method = RequestMethod.GET)
	public ResponseEntity<String> findLoggedInUsername() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    return ResponseEntity.ok(currentUserName);
		}

		return new ResponseEntity<String>("Unauthorized request!", HttpStatus.UNAUTHORIZED);

		
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<String> username() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String signed;
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			 signed = authentication.getName();
			 return ResponseEntity.ok(signed);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
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
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String signed;
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			signed = authentication.getName();
		} else {
			return ResponseEntity.badRequest().build();
		}
		
		System.out.println("1: " + authentication.getName());
		System.out.println("2: " + authentication.getCredentials());
		System.out.println("3: " + authentication.getPrincipal());
		System.out.println("4: " + authentication.getAuthorities());
		


		EndUser client = userService.findEndUserByUsername(signed);

		List<Reservation> reservations = reservationService.findMyReservations(client.getId());

		List<ReservationDTO> reservationsDto = new ArrayList<ReservationDTO>();
		
		reservationsDto = ReservationConverter.fromEntityList(reservations, r -> ReservationConverter.fromEntity(r));
		
		
		if (reservations == null) 
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.ok(reservationsDto);
	}
	
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> save(@RequestBody EndUserDTO client) throws Exception {
		
		EndUser eu = EndUserConverter.toEntity(client);
	
		System.out.println("MOJA   : : : : : : " + eu.getRoles().get(0));
		
		for (RoleDTO role : client.getRoles()) {
			if (role.getName().equals(Roles.END_USER)) {
				
				userService.save(eu);
				
				return new ResponseEntity<String>("Account successfully created!", HttpStatus.CREATED);
			}
		}

		return new ResponseEntity<String>("Unauthorized request!", HttpStatus.UNAUTHORIZED);
	}
	

}
