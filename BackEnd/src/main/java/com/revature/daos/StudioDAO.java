package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Anime;
import com.revature.models.Studio;

@Repository
public interface StudioDAO extends JpaRepository<Studio, Integer> {
	
	public Optional<List<Studio>> findByName(String name);
	
}