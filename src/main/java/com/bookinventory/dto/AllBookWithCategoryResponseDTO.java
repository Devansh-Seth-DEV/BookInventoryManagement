package com.bookinventory.dto;

/**
 * Data Transfer Object providing a flattened view of book metadata alongside its genre or category.
 * Used for displaying filtered results where the category context is required for the UI.
 */
public class AllBookWithCategoryResponseDTO {

    /**
     * The unique International Standard Book Number identifying the specific title.
     */
    private String isbn;

    /**
     * The official title of the book.
     */
    private String title;

    /**
     * The specific release version or edition of the publication.
     */
    private String edition;

    /**
     * A qualitative description of the category or genre the book is assigned to.
     */
    private String categoryDescription;

	public AllBookWithCategoryResponseDTO() {
	}

	public AllBookWithCategoryResponseDTO(
		String isbn, 
		String title, 
		String edition,
		String categoryDescription
	) {
		this.isbn = isbn;
		this.title = title;
		this.edition = edition;
		this.categoryDescription = categoryDescription;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getEdition() {
		return edition;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}
}
