package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Persistent entity representing a professional or community critic.
 * Maps to the 'reviewer' table and serves as the identity source for 
 * all qualitative feedback in the book ecosystem.
 */
@Entity
@Table(name = "reviewer")
public class Reviewer {
    
    /**
     * Unique internal identifier for the critic, 
     * automatically incremented to maintain an distinct audit trail.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewerID")
    private Integer reviewerId;

    /**
     * The display name of the reviewer. 
     * Required field with a 20-character limit for concise UI presentation.
     */
    @Column(
    	name = "Name", 
    	nullable = false, 
    	length = 20
    )
    private String name;

    /**
     * The organization or publication the reviewer represents (e.g., "The Times").
     * Provides professional context to the credibility of the review.
     */
    @Column(name = "EmployedBy", length = 30)
    private String employedBy;

    public Reviewer() {
    }

    public Reviewer(
    	Integer reviewerId,
        String name,
        String employedBy
    ) {
        this.reviewerId = reviewerId;
        this.name = name;
        this.employedBy = employedBy;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployedBy() {
        return employedBy;
    }

    public void setEmployedBy(String employedBy) {
        this.employedBy = employedBy;
    }
}