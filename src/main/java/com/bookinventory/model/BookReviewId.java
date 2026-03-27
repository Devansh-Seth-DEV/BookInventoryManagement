package com.bookinventory.model;

import java.io.Serializable;
import java.util.Objects;

public class BookReviewId implements Serializable {
    private String book; 
    private Integer reviewerID; 

    public BookReviewId() {}

    public BookReviewId(String book, Integer reviewerID) {
        this.book = book;
        this.reviewerID = reviewerID;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass())
        	return false;

        BookReviewId that = (BookReviewId) other;
        return Objects.equals(book, that.book) &&
        	   Objects.equals(reviewerID, that.reviewerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, reviewerID);
    }
}
