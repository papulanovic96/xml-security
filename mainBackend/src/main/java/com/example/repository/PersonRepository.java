package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.UPerson;

@Repository
public interface PersonRepository extends JpaRepository<UPerson, Long> {
	
	@Query(value = "SELECT * FROM persons", nativeQuery = true)
	List<UPerson> findItAll();
}
