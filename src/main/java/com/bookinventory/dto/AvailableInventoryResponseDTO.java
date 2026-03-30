package com.bookinventory.dto;

import java.math.BigDecimal;

public class AvailableInventoryResponseDTO {

    private String isbn;
    private Integer inventoryID;
    private String bookTitle;
    private String conditionDescription;
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
