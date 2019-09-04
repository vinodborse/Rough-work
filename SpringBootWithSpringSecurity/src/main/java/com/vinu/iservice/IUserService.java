package com.vinu.iservice;

import com.vinu.model.User;

/**
 * @author Vinod Borse
 * 04-Sep-2019
 */
public interface IUserService {
	User findByUsername(String username);

	void addUser(String userName, String firstName, String lastName, String password);
}
