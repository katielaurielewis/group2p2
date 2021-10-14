package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.Genre;
import com.revature.utils.HibernateUtil;

@Repository
public class GenreDAO implements GenreDaoInterface {
	

	@Override
	public boolean addGenre(Genre genre) {
		
		try {
			Session ses = HibernateUtil.getSession();
			ses.save(genre);
			HibernateUtil.closeSession();
			
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		return false;
		
	}

}