package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
	private Integer userId;
	
	@Column(name = "FirstName", length = 20, nullable = false)
	private String firstName;
	
	@Column(name = "LastName", length = 30, nullable = false)
	private String lastName;
	
	@Column(name = "PhoneNumber", length = 14)
	private String phoneNumber;
	
	@Column(name = "UserName", length = 30, nullable = false)
	private String userName;
	
	@Column(name = "Password", length = 30, nullable = false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "RoleNumber")
	private PermRole permRole;
	
	public User() {}

	public User(
		Integer userId, 
		String firstName,
		String lastName, 
		String phoneNumber, 
		String userName, 
		String password,
		PermRole permRole
	) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.permRole = permRole;
	}

	
	public User(
		String firstName,
		String lastName, 
		String phoneNumber, 
		String userName, 
		String password,
		PermRole permRole
	) {
		this(0, firstName, lastName, phoneNumber, userName, password, permRole);
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public PermRole getPermRole() {
		return permRole;
	}

	public void setPermRole(PermRole permRole) {
		this.permRole = permRole;
	}
}
