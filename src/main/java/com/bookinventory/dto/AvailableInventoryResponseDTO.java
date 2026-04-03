package com.bookinventory.dto;

import java.math.BigDecimal;

/**
 * Data Transfer Object representing a unique physical book copy ready for sale.
 * Used to provide real-time stock availability and pricing to the storefront.
 */
public class AvailableInventoryResponseDTO {

    /**
     * The unique International Standard Book Number for the title.
     */
    private String isbn;

    /**
     * The unique primary key for the specific physical unit in the warehouse.
     */
    private Integer inventoryID;

    /**
     * The official title of the book associated with this inventory unit.
     */
    private String bookTitle;

    /**
     * A qualitative assessment of the physical state (e.g., New, Used-Good).
     */
    private String conditionDescription;

    /**
     * The current market price assigned to this specific physical unit based on its condition.
     * Good conditioned books will have higher prices and Poor conditioned books have lower.
     */
    private BigDecimal price;

    public AvailableInventoryResponseDTO(String isbn,
                                         Integer inventoryID,
                                         String bookTitle,
                                         String conditionDescription,
                                         BigDecimal price
    ) {
        this.isbn = isbn;
        this.inventoryID = inventoryID;
        this.bookTitle = bookTitle;
        this.conditionDescription = conditionDescription;
        this.price = price;
    }

    public AvailableInventoryResponseDTO() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
