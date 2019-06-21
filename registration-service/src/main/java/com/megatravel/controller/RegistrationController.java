package com.megatravel.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.EndUser;
import com.megatravel.service.LoginService;
//import com.megatravel.service.LoginService;
import com.megatravel.service.MainService;
import com.megatravel.service.RegistrationService;
import com.megatravel.utility.UserValidator;


@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserValidator userValidator;
	
	
	public RegistrationController(MainService mainService) {
		this.mainService = mainService;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> register(@RequestBody EndUser user, BindingResult bindingResults) {
	
		userValidator.validate(user, bindingResults);
		
		if (bindingResults.hasErrors()) {
			for (Object object : bindingResults.getAllErrors()) {
			    if(object instanceof FieldError) {
			        FieldError fieldError = (FieldError) object;

			        return ResponseEntity.badRequest().body(fieldError.getCode().toString());
				}

			    if(object instanceof ObjectError) {
			        ObjectError objectError = (ObjectError) object;

			        return ResponseEntity.badRequest().body(objectError.getCode().toString());
			    }
			}
		}

		registrationService.complete(user);

		mainService.saveEndUser(user);
		
		loginService.autoLogin(user);
			
		return ResponseEntity.ok("Account successfully created!");
		
	}

}
