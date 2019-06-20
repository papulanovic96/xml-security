package com.megatravel.loginservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.loginservice.models.Agent;
import com.megatravel.loginservice.models.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();
	Agent findAgentByUsername(String name);
	
	@Query(value = "select * from agentLocalBase.user where user.dtype='Agent'", nativeQuery = true)
	List<Agent> findAgents();

	

}
