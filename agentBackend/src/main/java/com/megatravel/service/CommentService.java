package com.megatravel.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megatravel.model.Comment;
import com.megatravel.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository cRepository;

	@Transactional(rollbackFor = Exception.class)
	public void save(Comment comment) {
		cRepository.save(comment);
	}

	@Transactional(readOnly = true)
	public Comment findById(long id) {
		return cRepository.findById(id).orElse(null);
	}

}