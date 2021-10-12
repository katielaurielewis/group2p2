package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Watched_status")
public class WatchedStatus {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "watched_status_id")
	private int watched_status_id;
	
	@Column(name = "watched_status", nullable = false)
	private String watched_status;
	
	
	public WatchedStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public WatchedStatus(String watched_status) {
		super();
		this.watched_status = watched_status;
	}
	
	public WatchedStatus(int watched_status_id, String watched_status) {
		super();
		this.watched_status_id = watched_status_id;
		this.watched_status = watched_status;
	}
	
	@Override
	public String toString() {
		return "WatchedStatus [watched_status_id=" + watched_status_id + ", watched_status=" + watched_status + "]";
	}
	
	public int getWatched_status_id() {
		return watched_status_id;
	}
	
	public void setWatched_status_id(int watched_status_id) {
		this.watched_status_id = watched_status_id;
	}
	
	public String getWatched_status() {
		return watched_status;
	}
	
	public void setWatched_status(String watched_status) {
		this.watched_status = watched_status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((watched_status == null) ? 0 : watched_status.hashCode());
		result = prime * result + watched_status_id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WatchedStatus other = (WatchedStatus) obj;
		if (watched_status == null) {
			if (other.watched_status != null)
				return false;
		} else if (!watched_status.equals(other.watched_status))
			return false;
		if (watched_status_id != other.watched_status_id)
			return false;
		return true;
	}
	
	
	

}
