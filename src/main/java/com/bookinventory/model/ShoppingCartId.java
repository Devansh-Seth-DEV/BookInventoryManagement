package com.bookinventory.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Composite Key class representing the unique pairing of a User and a Book title.
 * Implements Serializable to ensure the shopping cart state can be managed 
 * across distributed sessions or persisted during server restarts.
 */
public class ShoppingCartId implements Serializable {

    /**
     * The unique ID of the customer who owns the cart.
     * Acts as the first segment of the composite primary key.
     */
    private Integer user;

    /**
     * The ISBN of the book title currently held in the cart.
     * Acts as the second segment of the composite primary key.
     */
    private String book;

    public ShoppingCartId() {
    }

    public ShoppingCartId(
    		Integer user, 
    		String book
    ) {
        this.user = user;
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShoppingCartId)) {
            return false;
        }
        ShoppingCartId that = (ShoppingCartId) o;
        return Objects.equals(user, that.user) && 
               Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, book);
    }
}