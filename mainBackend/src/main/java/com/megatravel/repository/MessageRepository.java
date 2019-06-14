package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long>
{
	List<Message> findAll();
	List<Message> findByRecipientUsername(String username);
}
