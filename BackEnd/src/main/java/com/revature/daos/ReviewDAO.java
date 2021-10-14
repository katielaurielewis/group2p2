package com.revature.daos;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.Review;

import com.revature.utils.HibernateUtil;

@Repository
public class ReviewDAO implements ReviewDaoInterface {
	

	@Override
	public void addReview(Review review) {
		Session ses = HibernateUtil.getSession();
		ses.save(review);
		HibernateUtil.closeSession();
		
	}

}
