package com.megatravel.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.megatravel.model.EndUser;
import com.megatravel.model.Role;
import com.megatravel.model.User;

@Service
@FeignClient(name="main-backend")
public interface MainService {   
    
	@RequestMapping(value="/user/findEndUser" , method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EndUser findEndUser(@RequestBody String clientUN);
	
	@RequestMapping(value="/user/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveEndUser(@RequestBody EndUser client);
	
	@RequestMapping(value="/roles/findEndUserRole", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Role findEndUserRole();
	
	
}


