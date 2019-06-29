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
        		.antMatchers(HttpMethod.GET, "/accommodation/findAllAvailable").permitAll()
        		.antMatchers(HttpMethod.GET, "/accommodation/findAll").permitAll()
	    		.antMatchers(HttpMethod.GET, "/user/findAllEndUsers").permitAll()
		        .antMatchers(HttpMethod.POST,"/user/save").permitAll()
		        .antMatchers(HttpMethod.POST,"/user/login/confirm").permitAll() 
		        .antMatchers(HttpMethod.POST,"/user/findEndUser").permitAll() 
		        .antMatchers(HttpMethod.GET, "/roles/findEndUserRole").permitAll()
		        .antMatchers(HttpMethod.POST, "/admin-agent-creation/saveAgent").permitAll()
		        .antMatchers(HttpMethod.GET, "/admin-agent-creation/findAgents").permitAll()
		        .antMatchers(HttpMethod.DELETE, "/end-user-action/delete/{username}").permitAll()
		        .antMatchers(HttpMethod.DELETE, "/end-user-action/block/{username}").permitAll()
		        .antMatchers(HttpMethod.DELETE, "/end-user-action/activate/{username}").permitAll()
		        .antMatchers(HttpMethod.POST, "/accommodation-category/save").permitAll()
		        .antMatchers(HttpMethod.DELETE, "/accommodation-category/delete/{id}").permitAll()
		        .antMatchers(HttpMethod.GET, "/accommodation-category/findById/{id}").permitAll()
		        .antMatchers(HttpMethod.GET, "/accommodation-category/findAll").permitAll()
		        .antMatchers(HttpMethod.PUT, "/accommodation-category/modify/{id}").permitAll()
		        .antMatchers(HttpMethod.POST, "/accommodation-type/save").permitAll()
		        .antMatchers(HttpMethod.DELETE, "/accommodation-type/delete/{id}").permitAll()
		        .antMatchers(HttpMethod.GET, "/accommodation-type/findById/{id}").permitAll()
		        .antMatchers(HttpMethod.GET, "/accommodation-type/findAll").permitAll()
		        .antMatchers(HttpMethod.PUT, "/accommodation-type/modify/{id}").permitAll()
		        .antMatchers(HttpMethod.POST, "/additional-services/save").permitAll()
		        .antMatchers(HttpMethod.DELETE, "/additional-services/delete/{id}").permitAll()
		        .antMatchers(HttpMethod.GET, "/additional-services/findById/{id}").permitAll()
		        .antMatchers(HttpMethod.GET, "/additional-services/findAll").permitAll()
		        .antMatchers(HttpMethod.PUT, "/additional-services/modify/{id}").permitAll()
		        .antMatchers(HttpMethod.POST, "/token/find").permitAll()
		        .antMatchers(HttpMethod.POST, "/token/save").permitAll()
		        .antMatchers(HttpMethod.POST, "/reservation/create").permitAll()
		        .antMatchers(HttpMethod.GET, "/user/reservations").permitAll()
		        .antMatchers(HttpMethod.POST, "/message/send").permitAll()
		        .antMatchers(HttpMethod.GET, "/message/history/*").permitAll()
		        .antMatchers(HttpMethod.GET, "/message/inbox").permitAll()
		        .antMatchers(HttpMethod.POST, "/accommodation/comment/{aid}").permitAll()
		        .antMatchers(HttpMethod.POST, "user/login/confirm").permitAll()
		        .antMatchers(HttpMethod.PUT, "/comment/accept/{id}").permitAll()
		        .antMatchers(HttpMethod.PUT, "/comment/refuse/{id}").permitAll()
		        .antMatchers(HttpMethod.GET, "/comment/notReviewed").permitAll()
		        .antMatchers(HttpMethod.GET, "/comment/accepted").permitAll()
		        .antMatchers(HttpMethod.GET, "/comment/byUserId/{id}").permitAll()
		        .antMatchers(HttpMethod.GET, "/end-user-action/findAll").permitAll()
		    .anyRequest().authenticated();


    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    
}
