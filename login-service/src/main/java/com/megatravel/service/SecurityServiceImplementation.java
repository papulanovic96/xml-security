package com.megatravel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImplementation implements SecurityService {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	private static final Logger logger = LoggerFactory.getLogger (SecurityServiceImplementation.class);
	
	@Override
	public String findLoggedInUsername() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    return currentUserName;
		}

		return "Unauthorized";

		
	}

	@Override
	public UsernamePasswordAuthenticationToken login(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	    
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

		Authentication auth =  authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
	    if (usernamePasswordAuthenticationToken.isAuthenticated()) {
	        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	        
	        logger.debug(String.format("Login %s successfully!", username));
	        
	        return usernamePasswordAuthenticationToken;
	    }
	    
	    return null;
		
	}

}
