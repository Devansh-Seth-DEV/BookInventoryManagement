package com.bookinventory.dto;

/**
 * Data Transfer Object representing a professional critique of a specific title.
 * Provides a flattened view of scores and qualitative feedback for frontend display.
 */
public class AllBookReviewResponseDTO {

    /**
     * The unique International Standard Book Number for the reviewed title.
     */
    private String isbn;

    /**
     * The full name of the professional critic or reviewer.
     */
    private String reviewerName;

    /**
     * The numerical score assigned to the book, typically on a 1-5 or 1-10 scale.
     */
    private Integer rating;

    /**
     * The detailed qualitative analysis and feedback provided by the reviewer.
     */
    private String comments;

    /**
     * The organization or publication the reviewer is professionally affiliated with.
     */
    private String reviewerEmployer;

    public AllBookReviewResponseDTO() {
    }

    public AllBookReviewResponseDTO(
            String isbn,
            String reviewerName,
            Integer rating,
            String comments,
            String reviewerEmployer
    ) {
        this.isbn = isbn;
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.comments = comments;
        this.reviewerEmployer = reviewerEmployer;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public Integer getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    public String getReviewerEmployer() {
        return reviewerEmployer;
    }
}