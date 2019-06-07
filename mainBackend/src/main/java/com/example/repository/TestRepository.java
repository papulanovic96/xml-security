package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

}
