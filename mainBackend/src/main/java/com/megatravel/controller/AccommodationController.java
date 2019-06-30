package com.megatravel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.converter.AccommodationConverter;
import com.megatravel.dto.AccommodationDTO;
import com.megatravel.model.Accommodation;
import com.megatravel.model.Comment;
import com.megatravel.model.CreateCommentRequest;
import com.megatravel.model.EndUser;
import com.megatravel.service.AcccommodationService;
import com.megatravel.service.CommentService;
import com.megatravel.service.UserService;

@RestController
@RequestMapping(value = "accommodation")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class AccommodationController {
	
	@Autowired
	private AcccommodationService accommodationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/findAllAvailable", method = RequestMethod.GET)
	public ResponseEntity<List<AccommodationDTO>> findAllAvailable() {

		List<Accommodation> accommodations = accommodationService.findAllAvailable();

		List<AccommodationDTO> accommodationsDto = new ArrayList<AccommodationDTO>();
		
		accommodationsDto = AccommodationConverter.fromEntityList(accommodations, acc -> AccommodationConverter.fromEntity(acc));
				
		if (accommodations == null)
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.ok(accommodationsDto);
		
	}
	

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Accommodation> findAll() {
		return accommodationService.findAll();
		
	}
	
	@RequestMapping(value = "/comment/{aid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> postCommente(@PathVariable("aid") String aid, @RequestBody CreateCommentRequest commentRequest) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String signed;
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			signed = authentication.getName();
		} else {
			return null;
		}
		
		EndUser client = userService.findEndUserByUsername(signed);

		Long id = Long.parseLong(aid);
		Accommodation accommodation = accommodationService.getAccommodationById(id);
		
		Comment comment = new Comment();
		
		comment.setContent(commentRequest.getContent());
		comment.setPostedBy(client);
		comment.setVisible(false);
		
		accommodation.getComments().add(comment);
		commentService.save(comment);
		
		return ResponseEntity.ok("Waiting...");
		
	}

}
