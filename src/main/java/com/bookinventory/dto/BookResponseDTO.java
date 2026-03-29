package com.bookinventory.dto;

public class BookResponseDTO {
	private String isbn;
	private String title;
	private String description;
	private String edition;
	private String categoryName;
	private String publisherName;
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
