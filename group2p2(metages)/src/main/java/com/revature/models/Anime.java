package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ers_reimbursement")
public class Anime {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "anime_id")
	private int anime_id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "anime_watched_status") 
	private WatchedStatus anime_watched_status;
	
	
	public Anime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Anime(WatchedStatus anime_watched_status) {
		super();
		this.anime_watched_status = anime_watched_status;
	}
	public Anime(int anime_id, WatchedStatus anime_watched_status) {
		super();
		this.anime_id = anime_id;
		this.anime_watched_status = anime_watched_status;
	}
	@Override
	public String toString() {
		return "Anime [anime_id=" + anime_id + ", anime_watched_status=" + anime_watched_status + "]";
	}
	public int getAnime_id() {
		return anime_id;
	}
	public void setAnime_id(int anime_id) {
		this.anime_id = anime_id;
	}
	public WatchedStatus getAnime_watched_status() {
		return anime_watched_status;
	}
	public void setAnime_watched_status(WatchedStatus anime_watched_status) {
		this.anime_watched_status = anime_watched_status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anime_id;
		result = prime * result + ((anime_watched_status == null) ? 0 : anime_watched_status.hashCode());
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
		Anime other = (Anime) obj;
		if (anime_id != other.anime_id)
			return false;
		if (anime_watched_status == null) {
			if (other.anime_watched_status != null)
				return false;
		} else if (!anime_watched_status.equals(other.anime_watched_status))
			return false;
		return true;
	}
	
	


}
