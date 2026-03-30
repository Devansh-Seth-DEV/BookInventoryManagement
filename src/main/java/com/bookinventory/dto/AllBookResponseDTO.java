package com.bookinventory.dto;

public class AllBookResponseDTO {
	private String isbn;
	private String title;
	private String description;
	private String edition;
	private String publisherName;
	
	public AllBookResponseDTO() {
		
	}

	public AllBookResponseDTO(
		String isbn,
		String title,
		String description,
		String edition,
		String publisherName
	) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.edition = edition;
		this.publisherName = publisherName;
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
}
