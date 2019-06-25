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
@FeignClient("zuul-server")
public interface MicroService {
	
	@RequestMapping(value="/main-backend/user/findEndUser", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EndUser findEndUser(@RequestBody String username);
	
	@RequestMapping(value="/main-backend/user/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveEndUser(@RequestBody EndUser eu);
	
	@RequestMapping(value="/main-backend/user/login/confirm", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void confirmLogin(@RequestBody UserDetails signedIn);
	
	@RequestMapping(value="/main-backend/roles/findEndUserRole", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Role findEndUserRole();

	@RequestMapping(value = "/login-service/findLogged", method = RequestMethod.GET)
	public String findLoggedInUsername();

	@RequestMapping(value = "/login-service/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void autoLogin(@RequestBody EndUser user);
}
