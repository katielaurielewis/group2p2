package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Genre;

import com.revature.utils.HibernateUtil;

public class GenreDAO implements GenreDaoInterface {
	

	@Override
	public void addGenre(Genre genre) {
		Session ses = HibernateUtil.getSession();
		ses.save(genre);
		HibernateUtil.closeSession();
		
	}

}
