package com.bookinventory.dto;

import java.math.BigDecimal;


/**
 * Data Transfer Object representing a successfully completed transaction.
 * Serves as the digital receipt and historical record for a user's past purchases.
 */
public class UserPurchaseDTO {

    /**
     * The unique primary key of the specific physical unit that was sold.
     */
    private Integer inventoryId;

    /**
     * The unique International Standard Book Number for the purchased title.
     */
    private String isbn;

    /**
     * The official title of the book at the time of purchase.
     */
    private String bookTitle;

    /**
     * The final sale price recorded at the moment the transaction was finalized.
     */
    private BigDecimal price;

    /**
     * The physical state of the book (e.g., New, Used) as it was when purchased.
     */
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
