package com.bookinventory.dto;

/**
 * Data Transfer Object representing a summary of books associated with a specific author.
 * Used for optimized catalog views where author and publisher metadata are flattened.
 */
public class AllBookOfAuthorResponseDTO {

    /**
     * The 10 or 13-digit unique International Standard Book Number.
     */
    private String isbn;

    /**
     * The full title of the book.
     */
    private String title;

    /**
     * The legal first name of the book's author.
     */
    private String authorFirstName;

    /**
     * The legal last name of the book's author.
     */
    private String authorLastName;

    /**
     * The name of the organization responsible for the book's publication.
     */
    private String pubilsherName;
	
	public AllBookOfAuthorResponseDTO() {
		
	}

	public AllBookOfAuthorResponseDTO(
		String isbn, 
		String title, 
		String authorFirstName,
		String authorLastName,
		String pubilsherName
	) {
		this.isbn = isbn;
		this.title = title;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.pubilsherName = pubilsherName;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public String getPubilsherName() {
		return pubilsherName;
	}
}
