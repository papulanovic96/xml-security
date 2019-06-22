package com.megatravel.service;

import javax.ws.rs.core.MediaType;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.megatravel.model.EndUser;

@Service
@FeignClient("login-service")
public interface LoginService {
	
	@RequestMapping(value = "/findLogged", method = RequestMethod.GET)
	public String findLoggedInUsername();

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public void autoLogin(@RequestBody EndUser user);

}
