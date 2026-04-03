package com.bookinventory.dto;

/**
 * Data Transfer Object representing an item currently held in a user's active shopping cart.
 * Provides the essential metadata required for the checkout and summary views.
 */
public class UserCartResponseDTO {

    /**
     * The unique International Standard Book Number for the item in the cart.
     */
    private String isbn;

    /**
     * The official title of the book the user intends to purchase.
     */
    private String bookTitle;

    /**
     * The specific release version or edition of the publication.
     */
    private String edition;

    /**
     * The name of the organization responsible for the book's publication.
     */
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