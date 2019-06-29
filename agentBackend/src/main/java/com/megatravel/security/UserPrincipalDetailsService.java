package com.megatravel.security;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.megatravel.model.Agent;
import com.megatravel.model.User;
import com.megatravel.repository.UserRepository;


@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    	System.out.println("usao u loadUserByUsername(String s) u UserPrincipalDetailsService klasi***");
        Agent agent = this.userRepository.findAgentByUsername(s);
        UserPrincipal userPrincipal = new UserPrincipal(agent);

        return userPrincipal;
    }
}
