package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookreview")
public class BookReview {

	@Id
	@Column(name = "ISBN", length = 13)
	private String isbn;

	@Id
	@Column(name = "ReviewerID")
	private Integer reviewerID;

	@Column(name = "Rating")
	private Integer rating;

	@Column(name = "Comments", length = 255)
	private String comments;

	public BookReview() {
		
	}

	public BookReview(String isbn, Integer reviewerID, Integer rating, String comments) {
		this.isbn = isbn;
		this.reviewerID = reviewerID;
		this.rating = rating;
		this.comments = comments;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getReviewerID() {
		return reviewerID;
	}

	public void setReviewerID(Integer reviewerID) {
		this.reviewerID = reviewerID;
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