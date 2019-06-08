package com.megatravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megatravel.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();
	User findByUsername(String name);

}
