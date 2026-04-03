package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Persistent entity representing a security role or access level.
 * Maps to the 'permrole' table and provides the classification 
 * used for Role-Based Access Control (RBAC) across the system.
 */
@Entity
@Table(name = "permrole")
public class PermRole {

    /**
     * Unique internal identifier for the role.
     * Automatically incremented to ensure distinct security levels.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoleNumber")
	private Integer roleNumber;
	
    /**
     * The human-readable name of the privilege level (e.g., "ADMIN", "USER").
     * Restricted to 30 characters for optimized security lookups.
     */
	@Column(name = "PermRole", length = 30)
	private String permRole;
	
	public PermRole() {}
	
	public PermRole(Integer roleNumber, String permRole) {
		this.roleNumber = roleNumber;
		this.permRole = permRole;
	}

	public PermRole(String permRole) {
		this(0, permRole);
	}

	public Integer getRoleNumber() {
		return roleNumber;
	}

	public void setRoleNumber(Integer roleNumber) {
		this.roleNumber = roleNumber;
	}

	public String getPermRole() {
		return permRole;
	}

	public void setPermRole(String permRole) {
		this.permRole = permRole;
	}
}
