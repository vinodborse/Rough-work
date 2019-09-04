package com.vinu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinu.idao.IUserDao;
import com.vinu.iservice.IUserService;
import com.vinu.model.User;

/**
 * @author Vinod Borse
 * 04-Sep-2019
 */
@Service
public class UserService implements IUserService {
	@Autowired
	  private IUserDao userDao;
	  
	@Override
	public User findByUsername(String username) {
		User user = userDao.findByUsername(username);
	    return user;
	}

	@Override
	public void addUser(String username, String firstName, String lastName, String password) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		user.setPassword(password);
		userDao.addUser(user);
	}
}
