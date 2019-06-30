package com.megatravel.loginservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.loginservice.models.Agent;
import com.megatravel.loginservice.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();
	@Query(value = "select * from agentLocalBase.users where users.dtype=1 && users.username= :username", nativeQuery = true)
	Agent findAgentByUsername(@Param("username") String username);
	
	@Query(value = "select * from agentLocalBase.users where users.dtype=1", nativeQuery = true)
	List<Agent> findAgents();
	
	

}
