package com.megatravel.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.megatravel.dto.soap.CprdCommentResponse;
import com.megatravel.dto.soap.CreateCommentRequest;
import com.megatravel.dto.soap.UpdateCommentRequest;
import com.megatravel.model.Accommodation;
import com.megatravel.model.Comment;
import com.megatravel.service.AccommodationService;
import com.megatravel.service.CommentService;

@Endpoint
public class CommentEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.megatravel.com/accommodation";
	
	private final CommentService commentService;
	
	private final AccommodationService accommodationService;


	public CommentEndpoint(CommentService commentService, AccommodationService accommodationService) {
		super();
		this.commentService = commentService;
		this.accommodationService = accommodationService;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCommentRequest")
    @ResponsePayload
    public CprdCommentResponse save(@RequestPayload CreateCommentRequest request) {
		
		System.out.println("COMMENT ENDPOINT");
		
		Comment comment = new Comment();
		
		Accommodation accommodation = accommodationService.findByName(request.getAccommodationName());
		
		comment.setContent(request.getContent());
		
		accommodation.getComments().add(comment);
		
		commentService.save(comment);
		accommodationService.save(accommodation);
		
		CprdCommentResponse response = new CprdCommentResponse();
		response.setFeedback("Comment has been sent!");
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCommentRequest")
    @ResponsePayload
    public CprdCommentResponse updateCommentRequest(@RequestPayload UpdateCommentRequest request) {
		
		System.out.println("COMMENT ENDPOINT");
				
		Comment comment = commentService.findById(request.getId());
		comment.setVisible(request.isStatus());
		
		commentService.save(comment);
		
		String status;
		if (request.isStatus())
			status = "approved";
		else
			status = "rejected";
			
		CprdCommentResponse response = new CprdCommentResponse();
		response.setFeedback("Comment has been " + status + "!");
		
		return response;
	}
	

}
