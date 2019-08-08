package com.restaurant.module;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users") 
public class User extends BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2413829873834119200L;
	
	@OneToOne
	private Role role;
	
	@OneToOne
	private Address address;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
