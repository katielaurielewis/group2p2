package com.revature.daos;

import java.util.List;

import com.revature.models.Anime;

public interface AnimeDaoInterface {

	void addAnime(Anime anime);

	List<Anime> getAllAnimes();

	Anime getAnimeById(int id);

	void updateAnimeWatchedStatus(Anime ersReimb);

	Anime getRandomAnime(int id) ;
	

}
