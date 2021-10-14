package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Studio;

import com.revature.utils.HibernateUtil;

public class StudioDAO implements StudioDaoInterface {


	@Override
	public void addStudio(Studio studio) {
		Session ses = HibernateUtil.getSession();
		ses.save(studio);
		HibernateUtil.closeSession();
		
	}
}