package com.megatravel.loginservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.megatravel.loginservice.models.Agent;
import com.megatravel.loginservice.models.Credentials;
import com.megatravel.loginservice.models.User;
import com.megatravel.loginservice.service.UserService;


@RestController
@RequestMapping("/login")
public class LoginResource {


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
	private UserService userservice;
    
    @RequestMapping(value = "/tryToLogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
    public boolean tryToLogin(@RequestBody Credentials cred) {
    	
    	Agent agent = userservice.findByUsername(cred.getUsername().toString());
    	System.out.println("u login resursu agentt je " + agent);
    	if( agent != null && agent.getPassword().equals(cred.getPassword().toString()))
    		return true;
    	else return false;
    		
    	
    }

}
