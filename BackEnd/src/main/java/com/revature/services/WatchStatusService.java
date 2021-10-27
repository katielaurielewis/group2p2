package com.revature.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.daos.WatchStatusDAO;
import com.revature.models.WatchStatus;

@Service
public class WatchStatusService {
	
	private WatchStatusDAO wsDAO;
	
	public WatchStatusService(WatchStatusDAO wsDAO) {
		this.wsDAO = wsDAO;
	}
	
	public WatchStatus findById(int watchStatusId) {
		Optional<WatchStatus> ws = wsDAO.findById(watchStatusId);
		if(!ws.isPresent()) {
			return null;
		}
		return ws.get();
	}
	
	public WatchStatus findByStatus(String status) {
		Optional<WatchStatus> ws = wsDAO.findByStatus(status);
		if(!ws.isPresent()) {
			return null;
		}
		return ws.get();
	}

}
