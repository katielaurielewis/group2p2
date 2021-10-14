package com.revature.daos;

import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.Anime;

import com.revature.utils.HibernateUtil;

@Repository
public class AnimeDAO implements AnimeDaoInterface {
	
	@Override
	public boolean addAnime(Anime anime) {
		
		try {
			Session ses = HibernateUtil.getSession();
			ses.save(anime);
			HibernateUtil.closeSession();
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		return false;
		

	}
	
	@Override
	public List<Anime> getAllAnimes() {
		
		try {
			Session ses = HibernateUtil.getSession();
			
			List<Anime> animes = ses.createQuery("From Anime").list();
			
			HibernateUtil.closeSession();
			
			return animes;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		return null;
	}

	
	@Override
	public Anime getAnimeById(int id) {
		
		try {
			Session ses = HibernateUtil.getSession();

			Anime animeById = ses.get(Anime.class, id);

			HibernateUtil.closeSession();

			return animeById;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		return null;
		
	}
	
	
	
	@Override
	public Anime getRandomAnime(int id) {
		
		try {
			Session ses = HibernateUtil.getSession();
			
			List<Anime> animes = ses.createQuery("From Anime").list();
			
			//The size of all animes
			int length = animes.size();
			
			Random rand = new Random();

			//random id
			id = rand.nextInt(length) + 1;
			
			//random anime
			Anime randomAnime = ses.get(Anime.class, id);
			
			HibernateUtil.closeSession();
			
			return randomAnime;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	
		HibernateUtil.closeSession();
		return null;
	}
	
}
