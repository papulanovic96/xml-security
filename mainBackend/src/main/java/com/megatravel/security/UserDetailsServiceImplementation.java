package com.megatravel.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.megatravel.model.EndUser;
import com.megatravel.model.Role;
import com.megatravel.service.UserService;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EndUser user = userService.findEndUserByUsername(username);
		
	    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	   
	    for (Role role : user.getRoles()){
	        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName().name()));
	    }
	    
	    
	    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

}
