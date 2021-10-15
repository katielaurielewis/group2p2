package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.Review;
import com.revature.utils.HibernateUtil;

@Repository
public interface ReviewDAO implements JpaRepository<Review Integer> {
	
	public Optional<List<Review>> findByName(String name);
	
}
