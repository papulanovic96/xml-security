package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.megatravel.model.Agent;
import com.megatravel.model.EndUser;
import com.megatravel.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long>
{
	List<Message> findAll();
	
	@Query(value = "select * from booking.message where message.agent_id = '?1' and message.end_user_id = '?2'", nativeQuery = true)
	List<Message> findChatHistory(Long agentId, Long clientId);
	
	@Query(value = "select * from booking.message where message.end_user_id = '?1'", nativeQuery = true)
	List<Message> findMyInbox(Long clientId);
	
}
