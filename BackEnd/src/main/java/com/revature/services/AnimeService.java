package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

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

@Service
public class AnimeService {
	
	AnimeDAO aDao = new AnimeDAO();
	UserAnimeDAO uaDao = new UserAnimeDAO();
	WatchStatusDAO wDao = new WatchStatusDAO();
	GenreDAO gDao = new GenreDAO();
	StudioDAO sDao = new StudioDAO();
	ReviewDAO rDao = new ReviewDAO();

	public boolean addAnime(Anime anime) {
		
		return aDao.addAnime(anime);

	}
		
	public List<Anime> getAllAnimes() {
		
		return aDao.getAllAnimes();
		
	}

	public Anime getAnimeById(int id) {
		     
		return aDao.getAnimeById(id);
		
	}
	
	//I believe we are going to need this instead of the one with WatchStatus, so we change the actual user's status, not the record in the database
	public boolean updateAnimeWatchStatus(UserAnime uAnime) {
		return uaDao.updateAnimeWatchStatus(uAnime);
	}

	
	public Anime getRandomAnime(int id) {
		return aDao.getRandomAnime(id);
	
	}


	public boolean addWatchStatus(WatchStatus watchStatus) {
		return wDao.addWatchStatus(watchStatus);
		
	}
	
	public boolean addGenre(Genre genre) {
		return gDao.addGenre(genre);
		
	}
	
	public boolean addStudio(Studio studio) {
		return sDao.addStudio(studio);
	}
	
	public boolean addReview(Review review) {
		return rDao.addReview(review);
	}
	

}
