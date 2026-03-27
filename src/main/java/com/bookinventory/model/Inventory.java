package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InventoryID")
    private Integer inventoryId;

    @ManyToOne
    @JoinColumn(name = "ISBN", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "Ranks", nullable = false)
    private BookCondition bookCondition;

    @Column(name = "Purchased")
    private Boolean purchased;

    public Inventory() {
    }

    public Inventory(
    	Integer inventoryId,
    	Book book,
    	BookCondition bookCondition,
    	Boolean purchased
    ) {
        this.inventoryId = inventoryId;
        this.book = book;
        this.bookCondition = bookCondition;
        this.purchased = purchased;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookCondition getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(BookCondition bookCondition) {
        this.bookCondition = bookCondition;
    }

    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }
}