package com.bookinventory.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Composite Key class representing the unique pairing of a Book and a Reviewer.
 * Implements Serializable to satisfy JPA requirements for many-to-many bridge 
 * table identifiers.
 */
public class BookReviewId implements Serializable {

    /**
     * The ISBN of the book being reviewed, acting as the first segment of the primary key.
     */
    private String book; 

    /**
     * The unique ID of the reviewer, acting as the second segment of the primary key.
     */
    private Integer reviewer;

    public BookReviewId() {
    }

    public BookReviewId(
            String book, 
            Integer reviewer
    ) {
        this.book = book;
        this.reviewer = reviewer;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        BookReviewId that = (BookReviewId) other;
        return Objects.equals(book, that.book) &&
               Objects.equals(reviewer, that.reviewer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, reviewer);
    }
}