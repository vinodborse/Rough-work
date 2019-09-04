package com.vinu.idao;

import com.vinu.model.User;

/**
 * @author Vinod Borse
 * 04-Sep-2019
 */
public interface IUserDao {
	User findByUsername(String username);

	void addUser(User user);
}
