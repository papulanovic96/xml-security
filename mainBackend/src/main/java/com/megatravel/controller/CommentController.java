package com.megatravel.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.dto.CommentDTO;
import com.megatravel.model.Comment;
import com.megatravel.model.EndUser;
import com.megatravel.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService cService;
	
	@RequestMapping(value = "/accept/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> allowingMethod(@PathVariable Long id) {
		cService.comfirm(id, true);
		return new ResponseEntity<String>("Comment accepted!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/refuse/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> refuseMethod(@PathVariable Long id) {
		cService.comfirm(id, false);
		return new ResponseEntity<String>("Comment refused!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/notReviewed", method = RequestMethod.GET)
	public ResponseEntity<List<CommentDTO>> allNotReviewed() {
		List<CommentDTO> lista = cService.findAllByAllowed(false);
		return new ResponseEntity<List<CommentDTO>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/byUserId/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<CommentDTO>> findAllByUserId(@PathVariable Long id) {
		List<CommentDTO> lista = cService.findAllByUserId(id);
		return new ResponseEntity<List<CommentDTO>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/accepted", method = RequestMethod.GET)
	public ResponseEntity<List<CommentDTO>> allReviewed() {
		List<CommentDTO> lista = cService.findAllByAllowed(true);
		return new ResponseEntity<List<CommentDTO>>(lista, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		List<CommentDTO> listica = cService.findAllByUserId(id);
		if(listica != null) {
			for(CommentDTO c: listica) {
				cService.delete(c);
			}
			return new ResponseEntity<String>(listica + " deleted!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Comments with user id: >" + id + "< not found!", HttpStatus.NOT_FOUND);
		}
	}



}
