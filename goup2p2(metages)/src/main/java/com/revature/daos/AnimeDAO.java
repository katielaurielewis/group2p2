package com.revature.daos;

import java.util.List;
import java.util.Random;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Anime;
import com.revature.utils.HibernateUtil;



public class AnimeDAO implements AnimeDaoInterface {
	
	
	
	
	@Override
	public void addAnime(Anime anime) {
		
		Session ses = HibernateUtil.getSession();
		ses.save(anime);
		HibernateUtil.closeSession();
		
		


	}
	
	@Override
	public List<Anime> getAllAnimes() {
		
		Session ses = HibernateUtil.getSession();
		
		List <Anime> animes = ses.createQuery("From Anime").list();
		
		HibernateUtil.closeSession();
		return animes;
		

	}

	

	
	@Override
	public Anime getAnimeById(int id) {
		
       Session ses = HibernateUtil.getSession();
		
       Anime ersById = ses.get(Anime.class, id);
		
		HibernateUtil.closeSession();
		return ersById;
		
		
		
	}
	
	
	
	@Override
	public void updateAnimeWatchedStatus(Anime anime) {
		
			Session ses = HibernateUtil.getSession();
			Transaction tran = ses.beginTransaction();
			
	        String HQL = "UPDATE Anime SET watched_status = '" + anime.getAnime_watched_status().getWatched_status_id() + 
	        		"' WHERE anime_id = " + anime.getAnime_id();
			
			//Instantiate a Query object with createQuery()
			Query q = ses.createQuery(HQL);
			
			//Send the update to the DB just like JDBC
			q.executeUpdate();
			
			
			//close transaction and session to prevent memory leak
			tran.commit();
			
			HibernateUtil.closeSession();
			
			
			
	
	}

	
	@Override
	public Anime getRandomAnime(int id) {
		Session ses = HibernateUtil.getSession();
		
		List <Anime> animes = ses.createQuery("From Anime").list();
		
		int length = animes.size();
		
		 Random rand = new Random();

		
		 id = rand.nextInt(length);
		
	       Anime randomAnime = ses.get(Anime.class, id);
			
			HibernateUtil.closeSession();
			return randomAnime;
		
		
	}


	



}
