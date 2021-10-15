package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.daos.UserDAO;
import com.revature.models.User;

//I just wanted to put the User services into its own class
@Service
public class UserService {

	UserDAO uDao = new UserDAO();
	
	public boolean addUser(User user) {
		return uDao.addUser(user);
		
	}
	
}
