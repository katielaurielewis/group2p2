package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.daos.UserDAO;
import com.revature.models.User;

@Service
public class LoginService {
	
	UserDAO uDao = new UserDAO();
	
	public boolean checkCredentials(String username, String password) {
        User u = uDao.getUserByUsername(username);
        
        if(u == null) {
            return false;
        }else if(password.equals(u.getPassword())) {
            return true;
        } else {
        return false;
        }
    } 


}
