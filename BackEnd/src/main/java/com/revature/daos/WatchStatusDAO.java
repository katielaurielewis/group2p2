package com.revature.daos;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.revature.models.WatchStatus;
import com.revature.utils.HibernateUtil;

public class WatchStatusDAO implements WatchStatusDaoInterface{
	
	
	@Override
	public void addWatchStatus(WatchStatus watchStatus) {
		

		Session ses = HibernateUtil.getSession();
		ses.save(watchStatus);
		HibernateUtil.closeSession();
		
	}
	

	@Override
	public void updateAnimeWatchStatus(WatchStatus watchStatus) { 
		
			Session ses = HibernateUtil.getSession();
			Transaction tran = ses.beginTransaction();
			
	        String HQL = "UPDATE WatchStatus SET status_name = '" + watchStatus.getStatus() 
	        		+ "' WHERE status_id = " + watchStatus.getId();
			
			Query q = ses.createQuery(HQL);
			
			
			q.executeUpdate();
			
			tran.commit();
			
			HibernateUtil.closeSession();
	

	}


}