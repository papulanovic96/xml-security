package com.megatravel.messageservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.ws.rs.core.MediaType;

import com.megatravel.messageservice.models.Message;



@RestController
@RequestMapping("/messages")
public class MessageResource {

    @Autowired
    private RestTemplate restTemplate;

  
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Message test() {
    	
    	Message por = new Message();
    	por.setContent("ovo je neka poruka");
    	return por;
    }
}
