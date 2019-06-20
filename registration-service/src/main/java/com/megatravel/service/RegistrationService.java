package com.megatravel.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.megatravel.model.EndUser;
import com.megatravel.model.UserStatus;

@Service
public class RegistrationService {
	
	@Autowired
	private MainService mainService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public EndUser complete(EndUser user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		user.getRoles().add(mainService.findEndUserRole());
		
		user.setStatus(UserStatus.ACTIVE);
		
		return user;
	}
	
}
