package com.megatravel.converter;

import com.megatravel.dto.response.ResponseMessage;
import com.megatravel.model.Message;

public class MessageConverter extends AbstractConverter {
	
	public static ResponseMessage toResponseFromEntityForAgent(Message message) {
		return new ResponseMessage(message.getClient().getUsername(), message.getContent(), message.getStatus());
	}
	
	public static ResponseMessage toResponseFromEntityForClient(Message message) {
		return new ResponseMessage(message.getAgent().getUsername(), message.getContent(), message.getStatus());
	}

}
