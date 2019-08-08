package com.restaurant.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Credential {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String userName;
	
	private String password;
		
	@OneToOne()
	private User user;
	
	public Credential() {}

	public Credential(long id, String userName, String password, User user) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
