package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Persistent entity representing a registered system user.
 * Maps to the 'user' table and manages the core credentials, 
 * contact information, and authorization level of an individual.
 */
@Entity
@Table(name = "user")
public class User {

    /**
     * Unique internal identifier for the user.
     * Automatically incremented to ensure distinct identity across the platform.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
	private Integer userId;
	
    /**
     * The user's given name. 
     * Required field used for personalized UI greetings and documentation.
     */
	@Column(
		name = "FirstName", 
		length = 20, 
		nullable = false
	)
	private String firstName;
	
    /**
     * The user's family name. 
     * Required field for official records and account identification.
     */
	@Column(
		name = "LastName", 
		length = 30, 
		nullable = false
	)
	private String lastName;
	
    /**
     * The user's primary contact number.
     * Formatted with a length of 14 to accommodate international dialing codes.
     */
	@Column(name = "PhoneNumber", length = 14)
	private String phoneNumber;
	
    /**
     * The unique handle used by the user to log into the application.
     * Required field with a 30-character limit to ensure database-level uniqueness.
     */
	@Column(
		name = "UserName", 
		length = 30, 
		nullable = false
	)
	private String userName;
	
    /**
     * The user's access credential. 
     * Required field; typically encrypted before persistence in production.
     */
	@Column(
		name = "Password", 
		length = 30, 
		nullable = false
	)
	private String password;
	
    /**
     * The specific security clearance assigned to this user.
     * Linked via a Many-to-One relationship to the PermRole entity for RBAC.
     */
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
		this(0,
			firstName, 
			lastName, 
			phoneNumber, 
			userName, 
			password, 
			permRole);
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
