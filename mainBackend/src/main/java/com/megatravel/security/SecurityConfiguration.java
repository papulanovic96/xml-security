package com.megatravel.security;

import javax.ws.rs.HttpMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    }
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    		.csrf().disable();
        http.authorizeRequests()
	    		.antMatchers(HttpMethod.GET, "/user/findAllEndUsers").permitAll()
		        .antMatchers(HttpMethod.POST,"/user/save").permitAll()
		        .antMatchers(HttpMethod.POST,"/user/login/confirm").permitAll() 
		        .antMatchers(HttpMethod.POST,"/user/findEndUser").permitAll() 
		        .antMatchers(HttpMethod.GET, "/roles/findEndUserRole").permitAll()
		        .antMatchers(HttpMethod.POST, "/admin-agent-creation/saveAgent").permitAll()
		        .antMatchers(HttpMethod.GET, "/admin-agent-creation/findAgents").permitAll()
		    .anyRequest().authenticated();


    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    
}
