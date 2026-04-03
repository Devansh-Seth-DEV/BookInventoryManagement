package com.bookinventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Persistent entity representing a finalized sales transaction.
 * Maps to the 'purchaselog' table and utilizes a composite primary key (PurchaseLogId).
 * This acts as the historical record linking a specific customer to a specific physical unit.
 */
@Entity
@Table(name = "purchaselog")
@IdClass(PurchaseLogId.class)
public class PurchaseLog {

    /**
     * The customer who performed the transaction.
     * Part of the composite primary key, ensuring a historical link to the User entity.
     */
	@Id
	@ManyToOne
	@JoinColumn(
		name = "UserID",
		referencedColumnName = "UserID"
	)
	private User user;
	
    /**
     * The specific physical book unit that was sold.
     * Part of the composite primary key, providing a direct link to the Inventory asset.
     */
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
