package com.megatravel.loginservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.megatravel.loginservice.model.Agent;
import com.megatravel.loginservice.model.Credentials;
import com.megatravel.loginservice.model.User;
import com.megatravel.loginservice.service.UserService;


@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginResource {


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
	private UserService userservice;
    
    @RequestMapping(value = "/tryToLogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
    public boolean tryToLogin(@RequestBody Credentials cred) {
	
    	User agent = userservice.findByUsername(cred.getUsername().toString());
    
    	
    	
    	if( agent != null && agent.getPassword().equals(cred.getPassword().toString())) {
    		for(int i = 0; i < agent.getRoles().size(); i++) {
    			System.out.println("ROLA: " + agent.getRoles().get(i).getName());
    		}
    		
    		
    		return true;
    	}
    		
    	else return false;
    		
    	
    }

}
