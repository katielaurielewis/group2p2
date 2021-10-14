package com.revature.daos;

import com.revature.models.User;

public interface UserDaoInterface {
	
	User getUserByUsername(String username);
	
	User getUserByPassword(String password);
	
	void addUser(User user);

}
