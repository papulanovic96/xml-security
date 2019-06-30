package com.megatravel.loginservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.megatravel.loginservice.model.Agent;
import com.megatravel.loginservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();
	@Query(value = "select * from agentLocalBase.user where user.dtype=1 && user.username= :username", nativeQuery = true)
	Agent findAgentByUsername(@Param("username") String username);
	
	@Query(value = "select * from agentLocalBase.user where user.dtype=1", nativeQuery = true)
	List<Agent> findAgents();
	
	

}
