package com.revature.daos;

import com.revature.models.UserAnime;

public interface UserAnimeDaoInterface {

	void addUserAnime(UserAnime uAnime);
	
	void updateAnimeWatchStatus(UserAnime uAnime);
	
}
