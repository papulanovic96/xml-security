package com.megatravel.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.megatravel.model.Agent;
import com.megatravel.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

	
	private User user;
    public UserPrincipal(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        System.out.println("usao u getAuthorities() u userPrincipal klasi***");
        this.user.getRoles().forEach(r -> {
           /*
        	for(int i = 0; i < r.getPrivileges().size(); i++) {
        		GrantedAuthority authority = new SimpleGrantedAuthority(r.getPrivileges().get(i).getName());
                authorities.add(authority);
        	}
        */
        
        });
        

        // Extract list of roles (ROLE_name)
        this.user.getRoles().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r.getName());
            System.out.println("ROLA JE " + r.getName());
            authorities.add(authority);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
