package com.bookinventory.dto;

import java.math.BigDecimal;

public class AvailableInventoryResponseDTO {

    private String isbn;
    private String bookTitle;
    private String conditionDescription;
    private BigDecimal price;

    public AvailableInventoryResponseDTO(String isbn,
                                         String bookTitle,
                                         String conditionDescription,
                                         BigDecimal price
    ) {
        this.isbn = isbn;
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
