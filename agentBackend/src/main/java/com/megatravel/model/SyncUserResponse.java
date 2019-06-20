package com.megatravel.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
   "users"
})
@XmlRootElement(name = "sync_user_response")

public class SyncUserResponse {
	@XmlElement(required = true)
	private ArrayList<Agent> users;
	
	public SyncUserResponse() {}

	public ArrayList<Agent> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Agent> users) {
		this.users = users;
	}
}
