package com.bookinventory.dto;

public class AllBookReviewResponseDTO {
    private String isbn;
    private String reviewerName;
    private Integer rating;
    private String comments;
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