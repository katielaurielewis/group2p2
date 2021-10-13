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


//This model class is essentially a Join Table along with a status to tell if they have watched it

@Entity
@Table(name = "user_animes")
public class UserAnime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_anime_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "anime_id")
	private Anime anime;
	
	//Now, we can make a status object for whether the user has finished watching
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "status_id")
	private WatchStatus watchStatus;

	
	//boilerplate code--------------------------------------------
	
	public UserAnime() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserAnime(int id, User user, Anime anime, WatchStatus watchStatus) {
		super();
		this.id = id;
		this.user = user;
		this.anime = anime;
		this.watchStatus = watchStatus;
	}


	public UserAnime(User user, Anime anime, WatchStatus watchStatus) {
		super();
		this.user = user;
		this.anime = anime;
		this.watchStatus = watchStatus;
	}


	@Override
	public String toString() {
		return "UserAnime [id=" + id + ", user=" + user.getUsername() + ", "
	+ "anime=" + anime.getTitle() + ", watchStatus=" + watchStatus + "]";
	}
	//should not have a infinite loop since I changed it to specific values rather than the whole object
	
	
	
}
