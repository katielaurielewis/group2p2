package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.models.User;

//I just wanted to put the User services into its own class
public class UserService {

	UserDAO uDao = new UserDAO();
	
	public void addUser(User user) {
		uDao.addUser(user);
		
	}
	
}
