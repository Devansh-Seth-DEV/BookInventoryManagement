package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookreview")
@IdClass(BookReviewId.class)
public class BookReview {
	@Id
	@ManyToOne
	@JoinColumn(
		name = "ISBN", 
		referencedColumnName = "ISBN", 
		columnDefinition = "CHAR(13)"
	)
	private Book book;
	
	@Id
    @ManyToOne
    @JoinColumn(
    	name = "ReviewerID", 
    	referencedColumnName = "ReviewerID"
    )
    private Reviewer reviewer;

	@Column(name = "Rating")
	private Integer rating;

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

	public void setReviewerID(Reviewer reviewer) {
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