package com.bookinventory.dto;

/**
 * Data Transfer Object identifying titles that require immediate restocking.
 * Used by administrative interfaces to trigger procurement alerts and supply chain actions.
 */
public class LowStockResponseDTO {

    /**
     * The unique International Standard Book Number for the depleting title.
     */
    private String isbn;

    /**
     * The official title of the book associated with the low inventory level.
     */
    private String bookTitle;

    /**
     * The current numerical count of physical units remaining in the warehouse.
     */
    private Long stock;

    public LowStockResponseDTO(String isbn, String bookTitle, Long stock) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.stock = stock;
    }

    public LowStockResponseDTO() {
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

    public Long getCurrentStock() {
        return stock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.stock = stock;
    }
}
