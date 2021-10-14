package com.revature.daos;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

@Repository
public class UserDAO implements UserDaoInterface {

	

	@Override
	public void addUser(User user) {
		Session ses = HibernateUtil.getSession();
		ses.save(user);
		HibernateUtil.closeSession();
		
	}


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




}
