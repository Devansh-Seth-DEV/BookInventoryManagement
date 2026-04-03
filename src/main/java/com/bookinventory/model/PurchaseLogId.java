package com.bookinventory.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Composite Key class representing the unique pairing of a User and an Inventory unit.
 * Implements Serializable to facilitate persistence and session management in 
 * the purchase auditing layer.
 */
public class PurchaseLogId 
	implements Serializable
{
    /**
     * The unique ID of the customer who made the purchase.
     * Acts as the first segment of the composite primary key.
     */
	private Integer user;

    /**
     * The unique ID of the physical book unit sold.
     * Acts as the second segment of the composite primary key.
     */
	private Integer inventory;
	
	public PurchaseLogId() {
		
	}

	public PurchaseLogId(Integer user, Integer inventory) {
		this.user = user;
		this.inventory = inventory;
	}
	
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass())
        	return false;

        PurchaseLogId that = (PurchaseLogId) other;
        return Objects.equals(user, that.user) && 
                Objects.equals(inventory, that.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, inventory);
    }
}
