package com.megatravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long>
{

}
