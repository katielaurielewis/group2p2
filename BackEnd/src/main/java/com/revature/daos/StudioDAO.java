package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.Studio;
import com.revature.utils.HibernateUtil;

@Repository
public interface StudioDAO implements JpaRepository<Studio Integer> {
	
	public Optional<List<Studio>> findByName(String name);
	
}