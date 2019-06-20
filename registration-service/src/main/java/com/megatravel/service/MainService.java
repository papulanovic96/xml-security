package com.megatravel.service;

import javax.ws.rs.core.MediaType;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.megatravel.model.EndUser;
import com.megatravel.model.Role;

@Service
@FeignClient(name="main-backend")
public interface MainService {   
    
	@RequestMapping(value="/user/findEndUser", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public EndUser findEndUser(@RequestBody String username);
	
	@RequestMapping(value="/user/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public EndUser saveEndUser(@RequestBody EndUser eu);
	
	@RequestMapping(value="/roles/findEndUserRole", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Role findEndUserRole();
	
	
}


