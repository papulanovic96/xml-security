package com.megatravel.security;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.megatravel.model.EndUser;
import com.megatravel.model.Role;
import com.megatravel.service.MainService;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
	
	@Autowired
	private MainService mainService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		EndUser user = mainService.findEndUser(username);

		System.out.println("MOJE : " + username);
		
	    Set grantedAuthorities = new HashSet<>();
	    for (Role role : user.getRoles()){
	        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName().toString()));
	    }

	    return new org.springframework.security.core.userdetails.User(user.getUsername(), 
	    user.getPassword(), grantedAuthorities);
	}

}
