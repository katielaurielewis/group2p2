package com.revature.services;

import java.util.List;
import java.util.Optional;

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
	
	public boolean addUser (User u) {
		
		if(u == null) {
			return false;
		}
		uDao.save(u);
		
		return true;
	}
	
	public User findByUsername(String username) {
		return uDao.findByUsername(username);
	}
	
	public User findById(int id){
		return uDao.findById(id).get();
	}
}
