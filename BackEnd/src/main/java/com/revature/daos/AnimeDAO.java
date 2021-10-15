package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Anime;

@Repository
public interface AnimeDAO extends JpaRepository<Anime, Integer> {
	
	public Optional<List<Anime>> findByName(String name);
	
}
