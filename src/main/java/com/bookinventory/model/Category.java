package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Persistent entity representing a book genre or classification.
 * Maps to the 'category' table and provides the organizational structure 
 * used for filtering and browsing the digital storefront.
 */
@Entity
@Table(name = "category")
public class Category {

    /**
     * Unique internal identifier for the category.
     * Automatically incremented by the database to ensure sequence integrity.
     */
    @Id
    @Column(name = "CatID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer catId;

    /**
     * The human-readable label for the category (e.g., "Science Fiction", "History").
     * Restricted to 24 characters for clean UI rendering and database efficiency.
     */
    @Column(name = "CatDescription", length = 24)
    private String catDescription;

    public Category() {
    	
    }

    public Category(Integer catId, String catDescription) {
        this.catId = catId;
        this.catDescription = catDescription;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

}
