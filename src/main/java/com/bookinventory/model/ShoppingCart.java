package com.bookinventory.model;

import jakarta.persistence.Column;
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
    @Column(name = "UserID")
    private Integer userId;

    @Id
    @Column(name = "ISBN", length = 13)
    private String isbn;

    @ManyToOne
    @JoinColumn(
            name = "UserID", 
            insertable = false, 
            updatable = false
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "ISBN", 
            insertable = false, 
            updatable = false
    )
    private Book book;

    public ShoppingCart() {
    }

    public ShoppingCart(
            Integer userId,
            String isbn
    ) {
        this.userId = userId;
        this.isbn = isbn;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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