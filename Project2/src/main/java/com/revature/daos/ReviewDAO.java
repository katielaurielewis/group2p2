package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Review;

import com.revature.utils.HibernateUtil;

public class ReviewDAO implements ReviewDaoInterface {
	

	@Override
	public void addReview(Review review) {
		Session ses = HibernateUtil.getSession();
		ses.save(review);
		HibernateUtil.closeSession();
		
	}

}
