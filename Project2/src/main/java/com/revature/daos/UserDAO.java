package com.revature.daos;

import org.hibernate.Session;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDAO implements UserDaoInterface {

	@Override
	public User getUserByUsername(String username) {
		 	Session ses = HibernateUtil.getSession();
			
		 	User userByUsername = ses.get(User.class, username);
			
			HibernateUtil.closeSession();
			return userByUsername;
	} 

	@Override
	public User getUserByPassword(String password) {
			Session ses = HibernateUtil.getSession();
		
			User userByPassword = ses.get(User.class, password);
			
			HibernateUtil.closeSession();
			return userByPassword;
	}
	
	@Override
	public void addUser(User user) {
		Session ses = HibernateUtil.getSession();
		ses.save(user);
		HibernateUtil.closeSession();
		
	}


}
