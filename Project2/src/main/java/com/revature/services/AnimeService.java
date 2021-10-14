package com.revature.services;

import java.util.List;
import com.revature.daos.AnimeDAO;
import com.revature.daos.GenreDAO;
import com.revature.daos.ReviewDAO;
import com.revature.daos.StudioDAO;
import com.revature.daos.UserDAO;
import com.revature.daos.WatchStatusDAO;
import com.revature.models.Anime;
import com.revature.models.Genre;
import com.revature.models.Review;
import com.revature.models.Studio;
import com.revature.models.User;
import com.revature.models.WatchStatus;


public class AnimeService {
	
	AnimeDAO aDao = new AnimeDAO();
	UserDAO uDao = new UserDAO();
	WatchStatusDAO wDao = new WatchStatusDAO();
	GenreDAO gDao = new GenreDAO();
	StudioDAO sDao = new StudioDAO();
	ReviewDAO rDao = new ReviewDAO();

	public void addAnime(Anime anime) {
		
		aDao.addAnime(anime);

	}
		
	public List<Anime> getAllAnimes() {
		
		return aDao.getAllAnimes();
		
	}

	public Anime getAnimeById(int id) {
		     
		return aDao.getAnimeById(id);
		
	}
		
	public void updateAnimeWatchStatus(WatchStatus watchStatus) { 
		
			wDao.updateAnimeWatchStatus(watchStatus);
			
	}

	
	public Anime getRandomAnime(int id) {
		return aDao.getRandomAnime(id);
	
	}


	public void addUser(User user) {
		uDao.addUser(user);
		
	}

	public void addWatchStatus(WatchStatus watchStatus) {
		wDao.addWatchStatus(watchStatus);
		
	}
	
	public void addGenre(Genre genre) {
		gDao.addGenre(genre);
		
	}
	
	public void addStudio(Studio studio) {
		sDao.addStudio(studio);
	}
	
	public void addReview(Review review) {
		rDao.addReview(review);
	}
	

}
