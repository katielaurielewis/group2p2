package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.models.User;

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
