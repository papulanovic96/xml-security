package com.megatravel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.megatravel.exception.ExceptionResponse;
import com.megatravel.model.EndUser;
import com.megatravel.model.Role;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private MicroService microService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		EndUser user = microService.findEndUser(username);

		if (user == null || user.getRoles() == null || user.getRoles().isEmpty()) {
	            throw new ExceptionResponse("Invalid username or password.", HttpStatus.UNAUTHORIZED);
	    }
		 
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
	    for (Role role : user.getRoles()){
	    	 grantedAuthorities = AuthorityUtils
                	.commaSeparatedStringToAuthorityList("ROLE_" + role.getName().name());
	    }
	    
	    System.out.println(grantedAuthorities.toString());
	    
	    
	    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	    
	    
	}

}
