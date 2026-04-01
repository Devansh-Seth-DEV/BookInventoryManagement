package com.bookinventory.dto;

import java.math.BigDecimal;


public class UserPurchaseDTO {
	private Integer inventoryId;
	private String isbn;
	private String bookTitle;
	private BigDecimal price;
	private String conditionDescription;
	
	public UserPurchaseDTO() {
		
	}

	public UserPurchaseDTO(
		Integer inventoryId,
		String isbn, 
		String bookTitle, 
		BigDecimal price, 
		String conditionDescription
	) {
		this.inventoryId = inventoryId;
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.price = price;
		this.conditionDescription = conditionDescription;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getConditionDescription() {
		return conditionDescription;
	}
}
