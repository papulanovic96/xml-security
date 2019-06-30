package com.megatravel.amin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = {"com.megatravel.config",
							   "com.megatravel.endpoints",
							   "com.megatravel.service", 
							   "com.megatravel.controller",
							   "com.megatravel.security",
							   "com.megatravel.dto",
							   "com.megatravel.converter"
							  })
@EntityScan(basePackages = {"com.megatravel.model"})
@EnableJpaRepositories(basePackages = {"com.megatravel.repository"})
@EnableEurekaClient
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class MainBackendApplication  extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(MainBackendApplication.class, args);
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}


	//extend remove
	
}


