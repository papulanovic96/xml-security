package com.megatravel.loginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

@ComponentScan(basePackages={"com.megatravel.loginservice.*"})
@EnableJpaRepositories(basePackages = {"com.megatravel.loginservice.repository"})
@EntityScan(basePackages = {"com.megatravel.loginservice.model"})

@EnableEurekaClient
public class LoginServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApp.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}

