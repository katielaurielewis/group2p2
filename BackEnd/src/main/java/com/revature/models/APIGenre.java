package com.revature.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class APIGenre {

	private String request_hash;
	private boolean request_cached;
	private long request_cache_expiry;
	private Genre mal_url;
	private int item_count;
	private List<Anime> anime;
	
	public APIGenre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public APIGenre(String request_hash, boolean request_cached, long request_cache_expiry, Genre mal_url,
			int item_count, List<Anime> anime) {
		super();
		this.request_hash = request_hash;
		this.request_cached = request_cached;
		this.request_cache_expiry = request_cache_expiry;
		this.mal_url = mal_url;
		this.item_count = item_count;
		this.anime = anime;
	}

	@Override
	public String toString() {
		return "APIGenre [request_hash=" + request_hash + ", request_cached=" + request_cached
				+ ", request_cache_expiry=" + request_cache_expiry + ", mal_url=" + mal_url + ", item_count="
				+ item_count + ", anime=" + anime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anime == null) ? 0 : anime.hashCode());
		result = prime * result + item_count;
		result = prime * result + ((mal_url == null) ? 0 : mal_url.hashCode());
		result = prime * result + (int) (request_cache_expiry ^ (request_cache_expiry >>> 32));
		result = prime * result + (request_cached ? 1231 : 1237);
		result = prime * result + ((request_hash == null) ? 0 : request_hash.hashCode());
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
		APIGenre other = (APIGenre) obj;
		if (anime == null) {
			if (other.anime != null)
				return false;
		} else if (!anime.equals(other.anime))
			return false;
		if (item_count != other.item_count)
			return false;
		if (mal_url == null) {
			if (other.mal_url != null)
				return false;
		} else if (!mal_url.equals(other.mal_url))
			return false;
		if (request_cache_expiry != other.request_cache_expiry)
			return false;
		if (request_cached != other.request_cached)
			return false;
		if (request_hash == null) {
			if (other.request_hash != null)
				return false;
		} else if (!request_hash.equals(other.request_hash))
			return false;
		return true;
	}

	public String getRequest_hash() {
		return request_hash;
	}

	public void setRequest_hash(String request_hash) {
		this.request_hash = request_hash;
	}

	public boolean isRequest_cached() {
		return request_cached;
	}

	public void setRequest_cached(boolean request_cached) {
		this.request_cached = request_cached;
	}

	public long getRequest_cache_expiry() {
		return request_cache_expiry;
	}

	public void setRequest_cache_expiry(long request_cache_expiry) {
		this.request_cache_expiry = request_cache_expiry;
	}

	public Genre getMal_url() {
		return mal_url;
	}

	public void setMal_url(Genre mal_url) {
		this.mal_url = mal_url;
	}

	public int getItem_count() {
		return item_count;
	}

	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	public List<Anime> getAnime() {
		return anime;
	}

	public void setAnime(List<Anime> anime) {
		this.anime = anime;
	}
	
}
