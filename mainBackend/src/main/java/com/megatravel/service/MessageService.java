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
	
	public List<Message> findChatHistory(String clientUn, String agentUn) {
		return messageRepository.findChatHistory(clientUn, agentUn);
	}
	
	public List<Message> findMyInbox(String clientUn) {
		return messageRepository.findMyInbox(clientUn);
	}

	public void save(Message message) {
		messageRepository.saveAndFlush(message);		
	}
	
	
	

}
