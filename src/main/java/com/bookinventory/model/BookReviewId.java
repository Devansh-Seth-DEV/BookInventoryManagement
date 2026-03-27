package com.bookinventory.model;

import java.io.Serializable;
import java.util.Objects;

public class BookReviewId implements Serializable {
    private String book; 
    private Integer reviewer;

    public BookReviewId() {}

    public BookReviewId(String book, Integer reviewer) {
        this.book = book;
        this.reviewer = reviewer;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass())
        	return false;

        BookReviewId that = (BookReviewId) other;
        return Objects.equals(book, that.book) &&
        	   Objects.equals(reviewer, that.reviewer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, reviewer);
    }
}
