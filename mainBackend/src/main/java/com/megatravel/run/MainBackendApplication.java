package com.megatravel.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.megatravel.*"})
@EntityScan("com.megatravel.model")
@EnableJpaRepositories("com.megatravel.repository")
public class MainBackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MainBackendApplication.class, args);
	}

}
