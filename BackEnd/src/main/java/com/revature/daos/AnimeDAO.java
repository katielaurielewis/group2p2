package com.revature.daos;

import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.Anime;

import com.revature.utils.HibernateUtil;

@Repository
public interface AnimeDAO implements JpaRepository<Anime Integer> {
	
	public Optional<List<Anime>> findByName(String name);
	
}
