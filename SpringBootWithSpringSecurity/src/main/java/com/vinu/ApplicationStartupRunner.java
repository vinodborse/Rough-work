package com.vinu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.vinu.dao.UserRepository;
import com.vinu.iservice.IUserService;
import com.vinu.model.User;

@Component
public class ApplicationStartupRunner implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;
    
	@Autowired
	private IUserService userService;

    @Override
    public void run( ApplicationArguments args ) throws Exception {
        createAdminUser();
    }

    private void createAdminUser() {
    	//userService.addUser("admin", "firstname", "lastname", "admin");
        User admin = createUser("firstName", "lastname", "admin", "admin" );
        userRepository.save( admin );
    }

    private User createUser(String firstName, String lastName, String username, String password ) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername( password );
        user.setPassword( username );
        return user;
    }
}
