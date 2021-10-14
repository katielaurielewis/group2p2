package com.revature.daos;

import java.util.List;

import com.revature.models.Anime;
import com.revature.models.UserAnime;
import com.revature.models.WatchStatus;

public interface AnimeDaoInterface {
	
	boolean addAnime(Anime anime);

	List<Anime> getAllAnimes();

	Anime getAnimeById(int id);


	Anime getRandomAnime(int id) ;

}