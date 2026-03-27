package com.bookinventory.model;

import java.io.Serializable;
import java.util.Objects;

public class PurchaseLogId 
	implements Serializable
{
	private Integer user;
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
        	   Objects.equals(inventory, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, inventory);
    }
}
