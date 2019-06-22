package com.megatravel.controller;


import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.Role;
import com.megatravel.model.Roles;
import com.megatravel.repository.RoleRepository;

@RestController
@RequestMapping(value = "roles")
public class RoleController {

	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public List<Role> findAllRoles() {
		return roleRepository.findAll();
	}
	
//	@Secured({"ADMIN"})
	@RequestMapping(value = "/findEndUserRole", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public Role findEndUserRole() {
		return roleRepository.findEndUserRole();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public Role save(@RequestBody Role role) {
		return roleRepository.save(role);
	}
	
	@RequestMapping(value = "/findAllUsers", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public Role find() {
		return roleRepository.findByName(Roles.END_USER);
	}

}
