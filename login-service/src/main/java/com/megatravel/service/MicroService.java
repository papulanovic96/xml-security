package com.megatravel.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.megatravel.model.EndUser;
import com.megatravel.model.Role;

@Service
@FeignClient(name="main-backend")
public interface MicroService {   

	@RequestMapping(value="/user/findEndUser", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EndUser findEndUser(@RequestBody String username);
	
	@RequestMapping(value="/user/login/confirm", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void confirmLogin(@RequestBody String username);
	
	
}


