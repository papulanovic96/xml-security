package com.megatravel.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient("main-backend")
public interface LoginService {
	
	@RequestMapping(value = "user/findAll", method=RequestMethod.GET)
	public String getUsers();

}
