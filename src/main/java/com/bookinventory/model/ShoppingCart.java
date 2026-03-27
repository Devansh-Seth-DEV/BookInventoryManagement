package com.bookinventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoppingcart")
@IdClass(ShoppingCartId.class)
public class ShoppingCart {
	@Id
    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

	@Id
    @ManyToOne
    @JoinColumn(name = "ISBN")
    private Book book;

    public ShoppingCart() {
    }
    

    public ShoppingCart(User user, Book book) {
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