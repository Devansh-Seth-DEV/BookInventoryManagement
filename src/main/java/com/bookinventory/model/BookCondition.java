package com.bookinventory.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

/**
 * Persistent entity representing the various physical states a book can be in.
 * Maps to the 'bookcondition' table and provides standardized grading criteria 
 * (e.g., New, Used, Damaged) that directly influence pricing.
 */
@Entity
@Table(name = "bookcondition")
public class BookCondition {

    /**
     * Unique internal identifier and ranking for the condition grade.
     * Automatically incremented by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ranks")
    private Integer ranks;

    /**
     * A brief, user-friendly label for the book's state (e.g., "Like New").
     */
    @Column(name = "Description", length = 50)
    private String description;

    /**
     * A detailed explanation of what this specific condition grade entails 
     * for the consumer (e.g., "May include minor shelf wear").
     */
    @Column(name = "FullDescription", length = 255)
    private String fullDescription;

    /**
     * The standardized price point associated with this condition grade.
     * Uses BigDecimal for financial precision with a 12,2 scale.
     */
    @Column(name = "Price", precision = 12, scale = 2)
    private BigDecimal price = new BigDecimal("30.00");


    public BookCondition() {
    }

    public BookCondition(
            Integer ranks,
            String description,
            String fullDescription,
            BigDecimal price
    ) {
        this.ranks = ranks;
        this.description = description;
        this.fullDescription = fullDescription;
        this.price = price;
    }

    public Integer getRanks() {
        return ranks;
    }

    public void setRanks(Integer ranks) {
        this.ranks = ranks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}