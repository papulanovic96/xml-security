package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megatravel.model.Agent;
import com.megatravel.model.EndUser;
import com.megatravel.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "select * from booking.users where users.dtype = 'EndUser' and users.username = ?1 ", nativeQuery = true)
	EndUser findEndUserByUsername(String name);
	
	@Query(value = "select * from booking.users where users.dtype = 'EndUser'", nativeQuery = true)
	List<EndUser> findEndUsers();
	
	@Query(value = "select * from booking.users where users.dtype = 'Agent' and users.username = ?1 ", nativeQuery = true)
	Agent findAgentByUsername(String name);
	
	
	

}
