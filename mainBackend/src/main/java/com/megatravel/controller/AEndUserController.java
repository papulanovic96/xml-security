package com.megatravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.converter.EndUserConverter;
import com.megatravel.dto.EndUserDTO;
import com.megatravel.model.EndUser;
import com.megatravel.service.AEndUserService;

@RestController
@RequestMapping("/end-user-action")
public class AEndUserController {
	
	@Autowired
	private AEndUserService euService;
	
	@RequestMapping(value = "/delete/{username}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable String username) {
		EndUser newUser = euService.findByUsername(username);
		EndUserDTO newUserDTO = EndUserConverter.fromEntity(newUser);
		if(newUserDTO != null) {
			euService.delete(newUserDTO);
			return new ResponseEntity<String>(newUserDTO.getUsername() + " deleted!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("User with username: >" + username + "< not found!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/block/{username}", method = RequestMethod.PUT)
	public ResponseEntity<String> blockUser(@PathVariable String username) {
		EndUser newUser = euService.findByUsername(username);
		EndUserDTO newUserDTO = EndUserConverter.fromEntity(newUser);
		if(newUserDTO != null) {
			euService.block(newUserDTO);
			return new ResponseEntity<String>(newUserDTO.getUsername() + " blocked!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("User with username: >" + username + "< not found!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/activate/{username}", method = RequestMethod.PUT)
	public ResponseEntity<String> activateUser(@PathVariable String username) {
		EndUser newUser = euService.findByUsername(username);
		EndUserDTO newUserDTO = EndUserConverter.fromEntity(newUser);
		if(newUserDTO != null) {
			euService.active(newUserDTO);
			return new ResponseEntity<String>(newUserDTO.getUsername() + " activated!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("User with username: >" + username + "< not found!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<EndUserDTO> test() {
		return euService.findAll();
	}



}