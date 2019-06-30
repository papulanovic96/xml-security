package com.megatravel.dto;

public class CommentDTO {
	
    private long id;
	
    private String content;

    private boolean visible;
    
    private String postedBy;
    
    public CommentDTO() {
    	
    }
    
    public CommentDTO(long id, String content, boolean visible, String postedBy) {
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

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	

}