package com.megatravel.run;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = {"com.megatravel.config",
							   "com.megatravel.endpoints",
							   "com.megatravel.service", 
							   "com.megatravel.controller",
							   "com.megatravel.security",
							   "com.megatravel.dto"
							  })
@EntityScan(basePackages = {"com.megatravel.model"})
@EnableJpaRepositories(basePackages = {"com.megatravel.repository"})
@EnableEurekaClient
public class MainBackendApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MainBackendApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	//extend remove
	
}


