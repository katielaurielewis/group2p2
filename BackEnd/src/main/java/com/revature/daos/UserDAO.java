package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

@Repository
public class UserDAO implements UserDaoInterface {

	@Override
	public boolean addUser(User user) {
		
		try {
			
			Session ses = HibernateUtil.getSession();
			ses.save(user);
			HibernateUtil.closeSession();
			
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		return false;
	}


	@Override
	public User getUserByUsername(String username) {
		 	
		try {
			Session ses = HibernateUtil.getSession();

			User userByUsername = ses.get(User.class, username);

			HibernateUtil.closeSession();
			return userByUsername;

		} catch (Exception e) {
			e.printStackTrace();
		}

		HibernateUtil.closeSession();
		return null;
	} 

	@Override
	public User getUserByPassword(String password) {
			
		try {
			Session ses = HibernateUtil.getSession();

			User userByPassword = ses.get(User.class, password);

			HibernateUtil.closeSession();
			return userByPassword;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		return null;
	}


}
