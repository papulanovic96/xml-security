package com.megatravel.converter;

import java.util.ArrayList;
import java.util.List;

import com.megatravel.dto.EndUserDTO;
import com.megatravel.dto.RoleDTO;
import com.megatravel.model.EndUser;
import com.megatravel.model.Role;

public class EndUserConverter extends AbstractConverter{

	public static EndUserDTO fromEntity(EndUser e) {
		EndUserDTO newUserDTO = new EndUserDTO();
		newUserDTO.setId(e.getId());
		newUserDTO.setUsername(e.getUsername());
		newUserDTO.setEmail(e.getEmail());
		newUserDTO.setFirstName(e.getFirstName());
		newUserDTO.setLastName(e.getLastName());
		newUserDTO.setPassword(e.getPassword());
		newUserDTO.setStatus(e.getStatus());
		List<Role> roles = e.getRoles();
		List<RoleDTO> rolesDTO = new ArrayList<RoleDTO>();
		for(Role role : roles) {
			RoleDTO newRole = new RoleDTO();
			newRole.setId(role.getId());
			newRole.setName(role.getName());
			rolesDTO.add(newRole);
		}
		newUserDTO.setRoles(rolesDTO);
		return newUserDTO;
	}
	
	public static EndUser toEntity(EndUserDTO d) {
		EndUser user = new EndUser();
		user.setId(d.getId());
		user.setUsername(d.getUsername());
		user.setEmail(d.getEmail());
		user.setFirstName(d.getFirstName());
		user.setLastName(d.getLastName());
		user.setPassword(d.getPassword());
		user.setStatus(d.getStatus());
		List<RoleDTO> rolesDTO = d.getRoles();
		List<Role> roles = new ArrayList<Role>();
		if(rolesDTO != null) {
			for(RoleDTO role : rolesDTO) {
				Role newRole = new Role();
				newRole.setId(role.getId());
				newRole.setName(role.getName());
				roles.add(newRole);
			}
		}
		user.setRoles(roles);
		return user;
	}
}
