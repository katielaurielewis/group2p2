package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

@Repository
public interface UserDAO implements JpaRepository<User Integer> {
	
	public Optional<List<User>> findByName(String name);
	
}
