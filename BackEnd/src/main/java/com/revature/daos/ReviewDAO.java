package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Review;

@Repository
public interface ReviewDAO extends JpaRepository<Review, String> {
	
//	public Optional<List<Review>> findByName(String anime);
	
}
