package com.megatravel.converter;

import com.megatravel.dto.CommentDTO;
import com.megatravel.model.Comment;
import com.megatravel.model.EndUser;

public class CommentConverter extends AbstractConverter{

	public static CommentDTO fromEntity(Comment e) {
		CommentDTO cDTO = new CommentDTO();
		cDTO.setId(e.getId());
		cDTO.setContent(e.getContent());
		cDTO.setVisible(e.isVisible());
		cDTO.setPostedBy(e.getPostedBy().getUsername());
		return cDTO;
	}
	
	public static Comment toEntity(CommentDTO d) {
		Comment c = new Comment();
		c.setId(d.getId());
		c.setContent(d.getContent());
		c.setVisible(d.isVisible());
		EndUser userPosted = new EndUser();
		userPosted.setUsername(d.getPostedBy());
		c.setPostedBy(userPosted);
		return c;
	}
}
