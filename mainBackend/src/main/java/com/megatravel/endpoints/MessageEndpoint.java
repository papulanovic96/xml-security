package com.megatravel.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.megatravel.model.Message;
import com.megatravel.model.SendMessageRequest;
import com.megatravel.model.SendMessageResponse;
import com.megatravel.repository.MessageRepository;

@Endpoint
public class MessageEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.megatravel.com/message";

	private MessageRepository messageRepository;
	
	@Autowired
	public MessageEndpoint(MessageRepository mr) {
		this.messageRepository = mr;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendMessageRequest")
    @ResponsePayload
    public SendMessageResponse getCategory(@RequestPayload SendMessageRequest request) {
		SendMessageResponse response = new SendMessageResponse();
       
		Message m = (Message) request.getMessage();
		
		response.setStatus(((Message) request.getMessage()).getMessageStatus());
        System.out.println("stigao " + response.getStatus());
        
        
        return response;
    }

}
