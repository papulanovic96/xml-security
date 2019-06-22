package com.megatravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.model.Message;
import com.megatravel.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	public List<Message> findChatHistory(Long agentId, Long clientId) {
		return messageRepository.findChatHistory(agentId, clientId);
	}
	
	public List<Message> findMyInbox(Long clientId) {
		return messageRepository.findMyInbox(clientId);
	}
	
	
	

}
