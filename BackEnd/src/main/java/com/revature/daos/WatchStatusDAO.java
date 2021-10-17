package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.WatchStatus;

@Repository
public interface WatchStatusDAO extends JpaRepository<WatchStatus, String> {
	
	public Optional<List<WatchStatus>> findByStatus(String status);
	
}