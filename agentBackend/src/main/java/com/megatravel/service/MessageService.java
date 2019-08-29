package com.megatravel.service;

import java.util.List;

import javax.xml.soap.MessageFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import com.megatravel.dto.soap.CreateMessageRequest;
import com.megatravel.dto.soap.CreateMessageResponse;
import com.megatravel.exception.ExceptionResponse;
import com.megatravel.model.Agent;
import com.megatravel.model.EndUser;
import com.megatravel.model.Message;
import com.megatravel.model.MessageStatus;
import com.megatravel.model.Roles;
import com.megatravel.repository.MessageRepository;

@Service
public class MessageService {
	
	private final String MAIN_APP = "http://localhost:8761/main-backend/";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Transactional(readOnly = true)
	public List<Message> findChatHistory(String username) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Agent agent = null;
		EndUser client = null;
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			agent = userService.findAgent(authentication.getName());
			client = userService.findEndUser(username);
		}
		
		return messageRepository.findChatHistory(agent.getId(), client.getId());
	}

	@Transactional(readOnly = true)
	public List<Message> inbox() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Agent agent = null;
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			agent = userService.findAgent(authentication.getName());
		}
		
		return messageRepository.findMyInbox(agent.getId());
	}

	@Transactional(rollbackFor = Exception.class)
	public void save(Message message) {
		messageRepository.saveAndFlush(message);		
	}

	@Transactional(rollbackFor = Exception.class)
	public CreateMessageResponse send(CreateMessageRequest request) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Agent agent = null;
			
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			agent = userService.findAgent(authentication.getName());
		}
			
		EndUser client = userService.findEndUser(request.getRecipient());
			
		if (client == null) {
			 throw new ExceptionResponse(MessageStatus.UNKNOWN_USERNAME.name(), HttpStatus.BAD_REQUEST);
		}
			
		Message message = new Message();
		message.setAgent(agent);
		message.setClient(client);
		message.setSentBy(Roles.AGENT);
		message.setContent(request.getContent());
		message.setStatus(MessageStatus.DELIVIERED);
								
		try {
				SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(MessageFactory.newInstance());
	            messageFactory.afterPropertiesSet();
	
	            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory);
	            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	
	            marshaller.setContextPath("com.megatravel.model");
	            marshaller.afterPropertiesSet();
	
	            webServiceTemplate.setMarshaller(marshaller);
	            webServiceTemplate.setUnmarshaller(marshaller);
	            webServiceTemplate.afterPropertiesSet();
	
	            request.setSender(agent.getUsername());
	            
	            CreateMessageResponse response = null;
	            try {	
		            response = (CreateMessageResponse) webServiceTemplate.marshalSendAndReceive(MAIN_APP + "booking/message",request);
		            
		            save(message);
		            
	            } catch (Exception e) {
					 throw new ExceptionResponse("Sync db fail!", HttpStatus.INTERNAL_SERVER_ERROR);
				}
	            
	            
	            return response;
	            
		} catch (Exception s) {
	            s.printStackTrace();
				 throw new ExceptionResponse("Sync db fail!", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	public void recieve(CreateMessageRequest request) {
		EndUser client = userService.findEndUser(request.getSender());

		Agent agent = userService.findAgent(request.getRecipient());
		
		Message message = new Message();
		message.setClient(client);
		message.setAgent(agent);
		message.setContent(request.getContent());
		message.setSentBy(Roles.END_USER);
		message.setStatus(MessageStatus.DELIVIERED);		
		
		messageRepository.save(message);
	}
}
