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
	
	List<User> findAll();
	
	User findUserByUsername(String username);

	EndUser findEndUserByUsername(String name);

	EndUser findEndUserByEmail(String email);

	Agent findAgentByUsername(String username);
	
	@Query(value = "SELECT * FROM maindb.user WHERE user.dtype = 'EndUser'", nativeQuery = true)
	List<EndUser> findEndUsers();	
	
	@Query(value = "SELECT * FROM maindb.user WHERE user.dtype = 'Agent'", nativeQuery = true)
	List<Agent> findAgents();

	@Query(value =  "SELECT * FROM maindb.user as u " + 
					"JOIN accommodation AS a ON u.id = a.owned_by_id " + 
					"JOIN reservation AS r ON r.accommodation_id = a.id " + 
					"JOIN user_reservations AS ur ON ur.reservations_id = r.id " + 
					"WHERE end_user_id = ?1 GROUP BY owned_by_id", nativeQuery = true)
	List<Agent> findMyInbox(long clientId);


}
