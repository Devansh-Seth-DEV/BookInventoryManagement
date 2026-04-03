package com.bookinventory.dto;

/**
 * Data Transfer Object representing a summary of book metadata for catalog listing.
 * This DTO serves as the primary data exchange format for the storefront's 
 * global search and browse functionality.
 */
public class AllBookResponseDTO {

    /**
     * The unique International Standard Book Number identifying the specific title.
     */
    private String isbn;

    /**
     * The official title of the book.
     */
    private String title;

    /**
     * A brief summary or synopsis of the book's content.
     */
    private String description;

    /**
     * The specific release version or edition of the publication.
     */
    private String edition;

    /**
     * The name of the organization responsible for publishing the title.
     */
    private String publisherName;
    
    /**
     * The category or genere in which the book belongs
     */
    private String categoryName;
	
	public AllBookResponseDTO() {
		
	}

	public AllBookResponseDTO(
		String isbn,
		String title,
		String description,
		String edition,
		String publisherName,
		String categoryName
	) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.edition = edition;
		this.publisherName = publisherName;
		this.categoryName = categoryName;
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

	public String getPublisherName() {
		return publisherName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
