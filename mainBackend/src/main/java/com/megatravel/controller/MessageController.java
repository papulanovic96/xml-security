package com.megatravel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.model.Agent;
import com.megatravel.model.EndUser;
import com.megatravel.model.Message;
import com.megatravel.model.MessageStatus;
import com.megatravel.model.Reservation;
import com.megatravel.model.SendMessageRequest;
import com.megatravel.service.MessageService;
import com.megatravel.service.UserService;

@RestController
@RequestMapping(value = "message")
public class MessageController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value = "/send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageStatus> sendMessage(@RequestBody SendMessageRequest request) {
		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		
//		String signed;
//		
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//			signed = authentication.getName();
//		} else {
//			return null;
//		}
		
		EndUser client = userService.findEndUserByUsername("rabbit19");
		
		boolean reserved = false;
		for (Reservation reservation : client.getReservations()) {
			if (reservation.getAccommodation().getOwnedBy().getUsername().equals(request.getRecipientUsername())) {
				reserved = true;
			}
		}
		
		if (reserved == false)
			return new ResponseEntity<MessageStatus>(MessageStatus.UNKNOWN_USERNAME, HttpStatus.BAD_REQUEST);
		
		Agent agent = userService.findAgentByUsername(request.getRecipientUsername());
		
		if (agent == null) {
			 return new ResponseEntity<MessageStatus>(MessageStatus.UNKNOWN_USERNAME, HttpStatus.BAD_REQUEST);
		}
		
		Message message = new Message();

		message.setEndUserUn(client.getUsername());
		message.setAgentUn(request.getRecipientUsername());
		message.setContent(request.getContent());
		message.setMessageStatus(MessageStatus.DELIVIERED);
		
		messageService.save(message);
		
		return ResponseEntity.ok(MessageStatus.DELIVIERED);
	}
	
	@RequestMapping(value = "/inbox", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Message> inbox(@RequestBody String agentUn) {
		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		
//		String signed;
//		
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//			signed = authentication.getName();
//		} else {
//			return null;
//		}
		
		EndUser client = userService.findEndUserByUsername("rabbit19");
		
		return messageService.findMyInbox(client.getUsername());
	}
	
	@RequestMapping(value = "/history/{agentUn}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Message> chatHistory(@PathVariable("agentUn") String agentUn) {
		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		
//		String signed;
//		
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//			signed = authentication.getName();
//		} else {
//			return null;
//		}
		
		EndUser client = userService.findEndUserByUsername("rabbit19");

		boolean reserved = false;
		for (Reservation reservation : client.getReservations()) {
			if (reservation.getAccommodation().getOwnedBy().getUsername().equals(agentUn)) {
				reserved = true;
			}
		}
		
		if (reserved == false)
			return null;
//		
		return messageService.findChatHistory(agentUn, "rabbit19");
		
	}
	
	
	
	
}
