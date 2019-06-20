package com.megatravel.service;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.megatravel.model.EndUser;

@Service
@FeignClient(name="main-backend")
public interface RegistrationService {   
    
	@RequestMapping(value="/user/findAll", method=RequestMethod.GET)
    public List<EndUser> getEndUsers();
	
	@RequestMapping(value="/user/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public List<EndUser> saveEndUser(@RequestBody EndUser eu);

	@RequestMapping(value="/user/exist", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public EndUser exist(@RequestBody EndUser user);

	
	@RequestMapping(value="/user", method=RequestMethod.GET)
    public String getTest();
	
}


