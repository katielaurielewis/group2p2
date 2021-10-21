package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UserDAO;
import com.revature.models.User;

//I just wanted to put the User services into its own class
@Service
public class UserService {

	private UserDAO uDao;
	
	@Autowired
	public UserService (UserDAO uDao) {
		super();
		this.uDao = uDao;
	}
	
	public User addUser (User u) {
		
		if(u == null) {
			return null;
		}
		User returnedUser = uDao.save(u);
		
		return returnedUser;
	}
	
}
