package com.revature.daos;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.Genre;

import com.revature.utils.HibernateUtil;

@Repository
public class GenreDAO implements GenreDaoInterface {
	

	@Override
	public void addGenre(Genre genre) {
		Session ses = HibernateUtil.getSession();
		ses.save(genre);
		HibernateUtil.closeSession();
		
	}

}