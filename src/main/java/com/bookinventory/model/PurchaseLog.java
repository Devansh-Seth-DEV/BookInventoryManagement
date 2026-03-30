package com.bookinventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchaselog")
@IdClass(PurchaseLogId.class)
public class PurchaseLog {
	@Id
	@ManyToOne
	@JoinColumn(
		name = "UserID",
		referencedColumnName = "UserID"
	)
	private User user;
	
	@Id
	@ManyToOne
	@JoinColumn(
		name = "InventoryID",
		referencedColumnName = "InventoryID"
	)
	private Inventory inventory;
	
	public PurchaseLog() {
		
	}

	public PurchaseLog(
			User user,
			Inventory inventory
	) {
		this.user = user;
		this.inventory = inventory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}
