package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.WatchStatus;
import com.revature.utils.HibernateUtil;

@Repository
public interface WatchStatusDAO implements JpaRepository<WatchStatus Integer> {
	
	public Optional<List<WatchStatus>> findByName(String name);
	
}