package com.bookinventory.dto;

public class AllBookOfAuthorResponseDTO {
	private String isbn;
	private String title;
	private String authorFirstName;
	private String authorLastName;
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
