package com.bookinventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Persistent entity representing a customer's pending selections.
 * Maps to the 'shoppingcart' table and utilizes a composite primary key (ShoppingCartId).
 * Acts as an intermediate buffer between the catalog and the final purchase log.
 */
@Entity
@Table(name = "shoppingcart")
@IdClass(ShoppingCartId.class)
public class ShoppingCart {

    /**
     * The customer who owns this specific shopping session.
     * Part of the composite primary key, linking the cart directly to a User.
     */
	@Id
    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    /**
     * The specific book title currently reserved in the cart.
     * Part of the composite primary key, linking the cart directly to a Book title.
     */
	@Id
    @ManyToOne
    @JoinColumn(name = "ISBN")
    private Book book;

    public ShoppingCart() {
    }
    

    public ShoppingCart(
    		User user,
    		Book book
    ) {
		super();
		this.user = user;
		this.book = book;
	}


	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}