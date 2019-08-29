package com.megatravel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.converter.MessageConverter;
import com.megatravel.dto.response.ResponseMessage;
import com.megatravel.dto.soap.CreateMessageRequest;
import com.megatravel.dto.soap.CreateMessageResponse;
import com.megatravel.service.MessageService;


@RestController
@RequestMapping(value = "/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value = "/send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateMessageResponse> sendMessage(@RequestBody CreateMessageRequest request) {
		return ResponseEntity.ok(messageService.send(request));
	}
	
	@RequestMapping(value = "/inbox", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResponseMessage>> inbox() {	
		return ResponseEntity.ok(MessageConverter.fromEntityList(messageService.inbox(), (message -> MessageConverter.toResponseFromEntityForAgent(message))));
	}
	
	@RequestMapping(value = "/history/username={username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResponseMessage>> chatHistory(@PathVariable("username") String username) {
		return ResponseEntity.ok(MessageConverter.fromEntityList(messageService.findChatHistory(username), (message -> MessageConverter.toResponseFromEntityForAgent(message))));
		
	}
	
	
	
	
}