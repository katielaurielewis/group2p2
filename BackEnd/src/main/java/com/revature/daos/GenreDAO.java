package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.Genre;
import com.revature.utils.HibernateUtil;

@Repository
public interface GenreDAO implements JpaRepository<Genre Integer> {
	
	public Optional<List<Genre>> findByName(String name);
	
}