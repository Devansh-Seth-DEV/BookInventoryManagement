package com.bookinventory.dto;

public class LowStockResponseDTO {
    private String isbn;
    private String bookTitle;
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
