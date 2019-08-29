package com.megatravel.config;

import javax.ws.rs.HttpMethod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import com.megatravel.security.JwtAuthEntryPoint;
//import com.megatravel.security.JwtTokenFilterConfigurer;
//import com.megatravel.security.JwtTokenProvider;
//import com.megatravel.security.UserDetailsImplementation;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//    private JwtTokenProvider jwtTokenProvider;
//	@Autowired
//	private UserDetailsImplementation userDetailsService;
//	@Autowired
//	private JwtAuthEntryPoint unauthorizedHandler;
	    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Disable CSRF (cross site request forgery)
        http.csrf().disable();

        // No session will be created or used by spring security
        http
        	.sessionManagement()
        	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Entry points
        http.authorizeRequests()
                // Disallow everything else..
                .anyRequest().authenticated();

        // If a user try to access a resource without having enough permissions
        http
        	.exceptionHandling()
        	.accessDeniedPage("/login")
//        	.authenticationEntryPoint(unauthorizedHandler);
;

        // Apply JWT
//        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
       
        // Optional, if you want to test the API from a browser
        http.httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Allow eureka client to be accessed without authentication
        web.ignoring().antMatchers("/*/")//
        		.antMatchers("/eureka/**")//
                .antMatchers(HttpMethod.OPTIONS, "/**"); // Request type options should be allowed.
    }
    
//    @Override
//    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
//        authManagerBuilder
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(bCryptPasswordEncoder());
//    }
//    
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    

}
