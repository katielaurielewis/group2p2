package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


//This is based off the Studio object from the API, also the same as the Producer and Licensor object
	//Note, if we make any calls to the API for these, the URI is /producer

@Entity
@Table(name = "studios")
@Component
public class Studio {

	@Id
	@Column(name = "studio_id")
	private int id;
	
	@Column(name = "studio_name")
	private String name;

	//boilerplate code--------------------------------------------
	
	public Studio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Studio(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Studio(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Studio [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Studio other = (Studio) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
