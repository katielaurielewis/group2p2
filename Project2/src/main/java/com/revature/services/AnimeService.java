package com.revature.services;

import java.util.List;
import com.revature.daos.AnimeDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Anime;
import com.revature.models.User;
import com.revature.models.WatchStatus;


public class AnimeService {
	
	AnimeDAO aDao = new AnimeDAO();
	UserDAO uDao = new UserDAO();

	public void addAnime(Anime anime) {
		
		aDao.addAnime(anime);

	}
		
	public List<Anime> getAllAnimes() {
		
		return aDao.getAllAnimes();
		
	}

	public Anime getAnimeById(int id) {
		     
		return aDao.getAnimeById(id);
		
	}
		
	public void updateAnimeWatchStatus(Anime anime) { 
		
			aDao.updateAnimeWatchStatus(anime);
			
	}

	
	public Anime getRandomAnime(int id) {
		return aDao.getRandomAnime(id);
	
	}


	public void addUser(User user) {
		uDao.addUser(user);
		
	}

	public void addWatchStatus(WatchStatus watchStatus) {
		aDao.addWatchStatus(watchStatus);
		
	}

}
