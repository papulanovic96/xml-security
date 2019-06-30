package com.megatravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.converter.CommentConverter;
import com.megatravel.dto.CommentDTO;
import com.megatravel.model.Comment;
import com.megatravel.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository cRepository;
	
	public Comment save(CommentDTO comment) {
		Comment newComment = CommentConverter.toEntity(comment);
		return cRepository.save(newComment);
	}
	
	public Comment save(Comment comment) {
		return cRepository.save(comment);
	}
	
	public void delete(CommentDTO comment) {
		cRepository.deleteById(comment.getId());
	}
	
	public List<CommentDTO> findAllByUserId(Long id) {
		List<Comment> commentList = cRepository.findByUserId(id);
		List<CommentDTO> commentListDTO = CommentConverter.fromEntityList(commentList, e -> CommentConverter.fromEntity(e));
		return commentListDTO;
	}
	
	public List<CommentDTO> findAllByAllowed(boolean allowed) {
		List<Comment> commentList = cRepository.findByAllowed(allowed);
		List<CommentDTO> commentListDTO = CommentConverter.fromEntityList(commentList, e -> CommentConverter.fromEntity(e));
		return commentListDTO;
	}
	
	public boolean comfirm(Long id, boolean allowed) {
		Comment comment = cRepository.findById(id).orElse(null);
		comment.setVisible(allowed);
		cRepository.save(comment);
		return true;
	}
}
