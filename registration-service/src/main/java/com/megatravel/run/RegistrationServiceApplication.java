package com.megatravel.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableFeignClients("com.megatravel.*")
@Configuration
@ComponentScan(basePackages= {"com.megatravel.service", 
							  "com.megatravel.controller", 
							  "com.megatravel.validator",
							   "com.megatravel.security"})
@EntityScan("com.megatravel.model")
public class RegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationServiceApplication.class, args);
	}

}
