//package com.megatravel.endpoints;
//
//import javax.xml.soap.MessageFactory;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.ws.client.core.WebServiceTemplate;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
//
//import com.megatravel.model.Agent;
//import com.megatravel.model.EndUser;
//import com.megatravel.model.Message;
//import com.megatravel.model.MessageStatus;
//import com.megatravel.model.SendMessageRequest;
//import com.megatravel.model.SendMessageResponse;
//import com.megatravel.repository.MessageRepository;
//import com.megatravel.repository.UserRepository;
//import com.sun.research.ws.wadl.Response;
//
//@Endpoint
//public class MessageEndpoint {
//	
//	private static final String NAMESPACE_URI = "http://www.megatravel.com/message";
//	private static final String AGENT_APP_URI = "agentBackend";
//
//	private MessageRepository messageRepository;
//	
//	private UserRepository userRepository;
//	
//	
//		
//	@Autowired
//	public MessageEndpoint(MessageRepository mr, UserRepository userRepository) {
//		this.messageRepository = mr;
//		this.userRepository = userRepository;
//	}
//	
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendMessageRequest")
//    @ResponsePayload
//    public SendMessageResponse getCategory(@RequestPayload SendMessageRequest request) {
//		SendMessageResponse response = new SendMessageResponse();
//       
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		
//		EndUser sender = userRepository.findEndUserByUsername(auth.getPrincipal().toString());
//		
//		Agent recipient = userRepository.findAgentByUsername(request.getRecipientUsername());
//		
//		if (recipient == null) {
//			response.setStatus(MessageStatus.UNKNOWN_USERNAME);
//			return response;
//		}
//		
//		Message newMessage = new Message();
//		newMessage.setAgent(recipient);
//		newMessage.setMessageStatus(MessageStatus.SENDING);
//		
//		 Response msg;
//		
//		 try {
//	            SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(
//	                    MessageFactory.newInstance());
//	            messageFactory.afterPropertiesSet();
//
//	            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(
//	                    messageFactory);
//	            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//
//	            marshaller.setContextPath("com.megatravel.model");
//	            marshaller.afterPropertiesSet();
//
//	            webServiceTemplate.setMarshaller(marshaller);
//	            webServiceTemplate.afterPropertiesSet();
//
//	            Response reply = (Response) webServiceTemplate.marshalSendAndReceive
//	            				   (AGENT_APP_URI + "/booking/messages",request);
//
//	            msg = (Response) reply;
//	            
//	            
//	        } catch (Exception s) {
//	            s.printStackTrace();
//	        }
//		
//		
////		WebServiceTemplate wst = new WebServiceTemplate();
////		SendMessageResponse reply = (SendMessageResponse) wst.marshalSendAndReceive
////															 ("http://localhost:8081/booking/messages", 
////															  request,
////															  new SoapActionCallback(AGENT_APP_URI + "/SendMessageRequest"));
//		
//		recipient.getAchats().add(newMessage);
//		sender.getEuchats().add(newMessage);
//		
//		//procitaj iz reply status poruke
//		//response.setStatus(reply.get);
//       
//		System.out.println(sender.getUsername());
//		
//        return response;
//    }
//
//}
