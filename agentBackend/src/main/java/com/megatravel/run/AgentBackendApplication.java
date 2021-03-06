package com.megatravel.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableFeignClients("com.megatravel.*")
@ComponentScan(basePackages = {"com.megatravel.config",
							   "com.megatravel.controller",
							   "com.megatravel.endpoints",
							   "com.megatravel.exception", 
							   "com.megatravel.controller",
							   "com.megatravel.security",
							   "com.megatravel.service"
							  })
@EntityScan(basePackages = {"com.megatravel.model"})
@EnableJpaRepositories(basePackages = {"com.megatravel.repository"})
@EnableEurekaClient
public class AgentBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgentBackendApplication.class, args);
	}

}
