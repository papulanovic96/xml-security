package com.megatravel.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.megatravel.model.Administrator;
import com.megatravel.model.Agent;
import com.megatravel.model.EndUser;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableFeignClients("com.megatravel.*")
@ComponentScan(basePackages = {"com.megatravel.config",
							   "com.megatravel.endpoints",
							   "com.megatravel.service", 
							   "com.megatravel.controller",
							   "com.megatravel.security"
							  })
@EntityScan(basePackages = {"com.megatravel.model"})
@EnableJpaRepositories(basePackages = {"com.megatravel.repository"})
public class MainBackendApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		
		SpringApplication.run(MainBackendApplication.class, args);
	}


	
}


