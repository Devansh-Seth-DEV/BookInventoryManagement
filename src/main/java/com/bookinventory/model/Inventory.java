package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Persistent entity representing an individual physical copy of a book.
 * While the 'Book' entity represents the title, 'Inventory' tracks specific 
 * units, their current physical condition, and their availability for sale.
 */
@Entity
@Table(name = "inventory")
public class Inventory {

    /**
     * Unique internal tracking number for a specific physical unit.
     * Automatically incremented to ensure distinct identification of every copy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InventoryID")
    private Integer inventoryId;

    /**
     * The specific title this physical unit belongs to.
     * Established via a Mandatory Many-to-One relationship to the Book entity.
     */
    @ManyToOne
    @JoinColumn(name = "ISBN", nullable = false)
    private Book book;

    /**
     * The current quality or state of this specific copy (e.g., New, Used).
     * Linked to the BookCondition entity to determine the unit's pricing tier.
     */
    @ManyToOne
    @JoinColumn(name = "Ranks", nullable = false)
    private BookCondition bookCondition;

    /**
     * Flag indicating the availability of the unit.
     * Set to 'true' once a transaction is finalized to remove the item from the storefront.
     */
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