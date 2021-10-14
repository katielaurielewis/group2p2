package com.revature.daos;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.Studio;

import com.revature.utils.HibernateUtil;

@Repository
public class StudioDAO implements StudioDaoInterface {


	@Override
	public void addStudio(Studio studio) {
		Session ses = HibernateUtil.getSession();
		ses.save(studio);
		HibernateUtil.closeSession();
		
	}
}