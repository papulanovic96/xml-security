package com.megatravel.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;

import com.megatravel.model.EndUser;

public class CommentDTO {
	
    private long id;
	
    private String content;

    private boolean visible;
    
    private UserDTO postedBy;
    
    public CommentDTO() {
    	
    }
    
    public CommentDTO(long id, String content, boolean visible, UserDTO postedBy) {
		super();
		this.id = id;
		this.content = content;
		this.visible = visible;
		this.postedBy = postedBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public UserDTO getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(UserDTO postedBy) {
		this.postedBy = postedBy;
	}

	

}
