package com.megatravel.dto;

import java.util.List;

import com.megatravel.model.UserStatus;

public class EndUserDTO {

	private long id;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
    private List<RoleDTO> roles;
    private UserStatus status;
    
    public EndUserDTO() {
    	
    }
    
    public EndUserDTO(long id, String username, String password, String email, String firstName, String lastName, List<RoleDTO> roles, UserStatus status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
		this.status = status;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public List<RoleDTO> getRoles() {
		return roles;
	}


	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

    
}
