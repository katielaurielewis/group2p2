package com.revature.daos;

import java.util.List;

import com.revature.models.Anime;
import com.revature.models.User;
import com.revature.models.WatchStatus;

public interface AnimeDaoInterface {
	void addAnime(Anime anime);

	List<Anime> getAllAnimes();

	Anime getAnimeById(int id);

	void updateAnimeWatchStatus(Anime anime);

	Anime getRandomAnime(int id) ;
	
	void addWatchStatus(WatchStatus watchedStatus);
}