package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.WatchStatus;
import com.revature.utils.HibernateUtil;

@Repository
public class WatchStatusDAO implements WatchStatusDaoInterface{
	
	
	@Override
	public boolean addWatchStatus(WatchStatus watchStatus) {
		

		try {
			Session ses = HibernateUtil.getSession();
			ses.save(watchStatus);
			HibernateUtil.closeSession();
			
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		return false;
	}


}