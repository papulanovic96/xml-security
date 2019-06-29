package com.megatravel.dto;

import com.megatravel.model.Roles;

public class RoleDTO {

    protected long id;
	
    protected Roles name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Roles getName() {
		return name;
	}

	public void setName(Roles name) {
		this.name = name;
	}
    
}
