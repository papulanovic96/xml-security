package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.megatravel.model.Agent;
import com.megatravel.model.EndUser;
import com.megatravel.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();
	
	EndUser findEndUserByUsername(String name);
	User findByUsername(String name);
	@Query(value = "select * from booking.user where user.dtype = 'EndUser'", nativeQuery = true)
	List<EndUser> findEndUsers();
	
	
	
	

}
