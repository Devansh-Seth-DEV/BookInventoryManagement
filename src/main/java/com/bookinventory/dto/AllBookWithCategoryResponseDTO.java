package com.bookinventory.dto;

public class AllBookWithCategoryResponseDTO {
	private String isbn;
	private String title;
	private String edition;
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
