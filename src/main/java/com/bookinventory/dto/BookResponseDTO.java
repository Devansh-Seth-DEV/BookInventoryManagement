package com.bookinventory.dto;

/**
 * Data Transfer Object representing the comprehensive metadata for a specific book title.
 * Used for deep-dive detail views where category and publisher provenance are required.
 */
public class BookResponseDTO {

    /**
     * The 10 or 13-digit unique International Standard Book Number.
     */
    private String isbn;

    /**
     * The official full title of the book.
     */
    private String title;

    /**
     * The complete summary, synopsis, or blurb for the book's content.
     */
    private String description;

    /**
     * The specific release version or print edition of the publication.
     */
    private String edition;

    /**
     * The name of the genre or classification the book belongs to.
     */
    private String categoryName;

    /**
     * The official name of the organization that published the title.
     */
    private String publisherName;

    /**
     * The primary geographical location or headquarters of the publisher.
     */
    private String publisherCity;
	
	public BookResponseDTO() {
		
	}

	public BookResponseDTO(
		String isbn, 
		String title, 
		String description, 
		String edition, 
		String categoryName,
		String publisherName, 
		String publisherCity
	) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.edition = edition;
		this.categoryName = categoryName;
		this.publisherName = publisherName;
		this.publisherCity = publisherCity;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getEdition() {
		return edition;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public String getPublisherCity() {
		return publisherCity;
	}
}
