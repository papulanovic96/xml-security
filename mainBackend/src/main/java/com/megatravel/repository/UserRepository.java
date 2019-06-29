package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megatravel.model.Agent;
import com.megatravel.model.EndUser;
import com.megatravel.model.User;
import com.megatravel.model.UserStatus;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "select * from booking.user where user.dtype = 'EndUser' and user.username = ?1 ", nativeQuery = true)
	EndUser findEndUserByUsername(String name);
	
	@Query(value = "select * from booking.user where user.dtype = 'EndUser'", nativeQuery = true)
	List<EndUser> findEndUsers();
	
	@Query(value = "select * from booking.user where user.dtype = 'Agent' and user.username = ?1 ", nativeQuery = true)
	Agent findAgentByUsername(String name);
	
	@Query(value = "select * from booking.user where user.dtype = 'Agent'", nativeQuery = true)
	List<Agent> findAgent();
	
	@Modifying
	@Query(value = "UPDATE booking.user SET status = 1 WHERE username = ?1", nativeQuery = true)
	void blocked(String username);
	
	@Modifying
	@Query(value = "UPDATE booking.user SET status = 0 WHERE username = ?1", nativeQuery = true)
	void activated(String username);
	
	

}
