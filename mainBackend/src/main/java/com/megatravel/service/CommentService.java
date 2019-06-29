package com.megatravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.model.Comment;
import com.megatravel.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository cRepository;
	
	public Comment save(Comment comment) {
		return cRepository.save(comment);
	}
	
	public void delete(Comment comment) {
		cRepository.delete(comment);
	}
	
	public List<Comment> findAllByUserId(Long id) {
		return cRepository.findByUserId(id);
	}
	
	public List<Comment> findAllByAllowed(boolean allowed) {
		return cRepository.findByAllowed(allowed);
	}
	
	public boolean comfirm(Long id, boolean allowed) {
		Comment comment = cRepository.findById(id).orElse(null);
		comment.setVisible(allowed);
		cRepository.save(comment);
		return true;
	}
}
