package com.revature.daos;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.UserAnime;
import com.revature.utils.HibernateUtil;

public class UserAnimeDAO implements UserAnimeDaoInterface {

	@Override
	public void addUserAnime(UserAnime uAnime) {
		
		Session ses = HibernateUtil.getSession();
		ses.save(uAnime);
		HibernateUtil.closeSession();

	}

	@Override
	public void updateAnimeWatchStatus(UserAnime uAnime) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		
        String HQL = "UPDATE UserAnime SET watchStatus = " + uAnime.getWatchStatus() 
        		+ " WHERE id = " + uAnime.getId();
		
		Query q = ses.createQuery(HQL);
		
		
		q.executeUpdate();
		
		tran.commit();
		
		HibernateUtil.closeSession();
		
	}

}
