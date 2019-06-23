package com.megatravel.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.megatravel.model.Role;
import com.megatravel.model.Roles;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Query(value = "select * from booking.role where name = '2'", nativeQuery = true)
	public Role findEndUserRole();
	
	public Role findByName(Roles role);
	

	
}
