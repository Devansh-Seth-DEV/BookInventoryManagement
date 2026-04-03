package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/**
 * Persistent entity representing a critique of a specific book by a registered reviewer.
 * Maps to the 'bookreview' table and utilizes a composite primary key (BookReviewId).
 * Enforces a one-review-per-book constraint at the database level.
 */
@Entity
@Table(name = "bookreview")
@IdClass(BookReviewId.class)
public class BookReview {

    /**
     * The ISBN of the book being reviewed. 
     * Part of the composite primary key, explicitly defined as a 13-character string.
     */
    @Id
    @ManyToOne
    @JoinColumn(
            name = "ISBN", 
            referencedColumnName = "ISBN", 
            columnDefinition = "CHAR(13)"
    )
    private Book book;
    
    /**
     * The unique identifier of the reviewer providing the feedback.
     * Part of the composite primary key.
     */
    @Id
    @ManyToOne
    @JoinColumn(
            name = "ReviewerID", 
            referencedColumnName = "ReviewerID"
    )
    private Reviewer reviewer;

    /**
     * The numerical score assigned to the book (e.g., 1 to 5 stars).
     */
    @Column(name = "Rating")
    private Integer rating;

    /**
     * The written feedback or analysis provided by the reviewer.
     * Capped at 255 characters for consistent storage and display.
     */
    @Column(name = "Comments", length = 255)
    private String comments;

    public BookReview() {
    }

    public BookReview(
            Book book, 
            Reviewer reviewer, 
            Integer rating, 
            String comments
    ) {
        this.book = book;
        this.reviewer = reviewer;
        this.rating = rating;
        this.comments = comments;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}