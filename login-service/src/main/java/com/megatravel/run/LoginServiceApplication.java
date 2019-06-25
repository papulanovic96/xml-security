package com.megatravel.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableAutoConfiguration
@EnableFeignClients("com.megatravel.*")
@ComponentScan(basePackages= {"com.megatravel.controller",
							  "com.megatravel.security",
							  "com.megatravel.service"})
@EntityScan("com.megatravel.model")
@EnableEurekaClient
public class LoginServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}
	
	//extend remove

}
