package com.revature.daos;

import com.revature.models.UserAnime;

public interface UserAnimeDaoInterface {

	boolean addUserAnime(UserAnime uAnime);
	
	boolean updateAnimeWatchStatus(UserAnime uAnime);
	
}
