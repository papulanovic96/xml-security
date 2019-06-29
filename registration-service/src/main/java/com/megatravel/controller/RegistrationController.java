package com.megatravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.EndUser;
import com.megatravel.service.MicroService;
import com.megatravel.service.RegistrationService;
import com.megatravel.validator.UserValidator;

@RestController
@RequestMapping(value = "/")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private MicroService microService;
	
	@Autowired
	private UserValidator userValidator;
	
	
	public RegistrationController(MicroService microService, RegistrationService registrationService, UserValidator userValidator) {
		this.microService = microService;
		this.registrationService = registrationService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

		//loginService.autoLogin(user);
			
		return microService.saveEndUser(user);
		
	}

}
