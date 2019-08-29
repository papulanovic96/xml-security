package com.megatravel.dto.response;

import com.megatravel.model.MessageStatus;

public class ResponseMessage {
	
	private String from;
	
	private String content;

	private MessageStatus status;

	public ResponseMessage(String from, String content, MessageStatus status) {
		super();
		this.from = from;
		this.content = content;
		this.status = status;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MessageStatus getStatus() {
		return status;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}

}
