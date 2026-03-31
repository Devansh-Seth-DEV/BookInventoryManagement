package com.bookinventory.dto;

public class UserCartResponseDTO {

    private String isbn;
    private String bookTitle;
    private String edition;
    private String publisherName;

    public UserCartResponseDTO() {
    }

    public UserCartResponseDTO(String isbn, String bookTitle, String edition, String publisherName) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.edition = edition;
        this.publisherName = publisherName;
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

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}