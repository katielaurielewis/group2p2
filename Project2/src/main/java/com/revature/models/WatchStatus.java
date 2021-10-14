package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//This model class is essentially just another table to list off the different status types

@Entity
@Table(name = "watch_statuses")
public class WatchStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private int id;
	
	@Column(name = "status_name")
	private String status;

	
	//boilerplate code-----------------------------------------------
	public WatchStatus() {
		super();
		// TODO Auto-generated constructor stub
	}


	public WatchStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}


	public WatchStatus(String status) {
		super();
		this.status = status;
	}


	@Override
	public String toString() {
		return "WatchStatus [id=" + id + ", status=" + status + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		WatchStatus other = (WatchStatus) obj;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
