package com.vinu.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.vinu.dao.UserRepository;
import com.vinu.iservice.IUserService;
import com.vinu.model.User;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

/*    @Autowired
    private UserRepository repository;*/
    
	@Autowired
	private IUserService userService;

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        /*return Optional.ofNullable( this.repository.findByUsername( username ))
                .orElseThrow( () -> new UsernameNotFoundException( "This username is not registered." ) );*/
    	UserDetails user = userService.findByUsername(username);
		if(user == null){
			new UsernameNotFoundException( "This username is not registered." );
		}
    	return user;
    }
}