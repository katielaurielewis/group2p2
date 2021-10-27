package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.models.UserAnime;
import com.revature.models.WatchStatus;

@Repository
public interface UserAnimeDAO extends JpaRepository<UserAnime, Integer> {

	public Optional<List<UserAnime>> findByUser(User user);
	
	public Optional<List<UserAnime>> findByWatchStatus(WatchStatus watchStatus);
	
	public Optional<UserAnime> findTopByUserIdAndAnimeId(int userId, int animeId);

}
