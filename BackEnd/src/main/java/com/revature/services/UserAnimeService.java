package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UserAnimeDAO;
import com.revature.daos.WatchStatusDAO;
import com.revature.models.User;
import com.revature.models.UserAnime;
import com.revature.models.WatchStatus;

@Service
public class UserAnimeService {

	private UserAnimeDAO uaDAO;
	private WatchStatusDAO wsDAO;
	
	@Autowired
	public UserAnimeService(UserAnimeDAO uaDAO, WatchStatusDAO wsDAO) {
		this.uaDAO = uaDAO;
		this.wsDAO = wsDAO;
	}
	
	public Optional<List<UserAnime>> findByUser(User user){
		return uaDAO.findByUser(user);
	}

	public UserAnime save(UserAnime uAnime) {
		return uaDAO.save(uAnime);
	}
	
	public UserAnime setWatched(int userId, int animeId) {
		Optional<UserAnime> opt = uaDAO.findTopByUserIdAndAnimeId(userId, animeId);
		if(!opt.isPresent()) {
			return null;
		}
		UserAnime ua = opt.get();
		WatchStatus watched = wsDAO.findByStatus("Watched").get();
		ua.setWatchStatus(watched);
		uaDAO.save(ua);
		
		return ua;
	}
	
}
