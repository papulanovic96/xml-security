package com.megatravel.config;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.megatravel.model.SyncUserRequest;
import com.megatravel.model.SyncUserResponse;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SOAPConnector extends WebServiceGatewaySupport {
	
	private static final String serviceURI = "";
	
	public Object callWebService(String url, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
  
	}

	public SyncUserResponse syncUserRequest() {
		
		SyncUserRequest req = new SyncUserRequest();
		
		return (SyncUserResponse) getWebServiceTemplate().marshalSendAndReceive(serviceURI, req, new SoapActionCallback("/"));

	
	}
	
}
