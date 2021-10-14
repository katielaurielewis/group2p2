package com.revature.services;

import java.util.List;
import com.revature.daos.AnimeDAO;
import com.revature.daos.GenreDAO;
import com.revature.daos.ReviewDAO;
import com.revature.daos.StudioDAO;
import com.revature.daos.UserAnimeDAO;
import com.revature.daos.WatchStatusDAO;
import com.revature.models.Anime;
import com.revature.models.Genre;
import com.revature.models.Review;
import com.revature.models.Studio;
import com.revature.models.UserAnime;
import com.revature.models.WatchStatus;

//@Service - not sure why this isnt working
public class AnimeService {
	
	AnimeDAO aDao = new AnimeDAO();
	UserAnimeDAO uaDao = new UserAnimeDAO();
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
	
	//I believe we are going to need this instead of the one above, so we change the actual user's status, not the record in the database
	public void updateAnimeWatchStatus(UserAnime uAnime) {
		uaDao.updateAnimeWatchStatus(uAnime);
	}

	
	public Anime getRandomAnime(int id) {
		return aDao.getRandomAnime(id);
	
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
