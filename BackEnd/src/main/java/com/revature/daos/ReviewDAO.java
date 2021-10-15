package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.Review;
import com.revature.utils.HibernateUtil;

@Repository
public class ReviewDAO implements ReviewDaoInterface {
	

	@Override
	public boolean addReview(Review review) {
		
		try {
			Session ses = HibernateUtil.getSession();
			ses.save(review);
			HibernateUtil.closeSession();
			
			return true;
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		return false;
	}

}
