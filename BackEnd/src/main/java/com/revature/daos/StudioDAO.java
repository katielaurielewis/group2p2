package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.Studio;
import com.revature.utils.HibernateUtil;

@Repository
public class StudioDAO implements StudioDaoInterface {


	@Override
	public boolean addStudio(Studio studio) {
		
		try {
			Session ses = HibernateUtil.getSession();
			ses.save(studio);
			HibernateUtil.closeSession();
			
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		return false;
		
	}
}