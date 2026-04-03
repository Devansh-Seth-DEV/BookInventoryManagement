package com.bookinventory.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;

/**
 * Associative entity representing the relationship between a Book and an Author.
 * Maps to the 'bookauthor' join table and uses a composite primary key (BookAuthorId).
 * Allows for the storage of relationship-specific attributes like authorship priority.
 */
@Entity
@Table(name = "bookauthor")
@IdClass(BookAuthorId.class)
public class BookAuthor {

    /**
     * The associated Book entity. Part of the composite primary key.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "ISBN")
    private Book book;

    /**
     * The associated Author entity. Part of the composite primary key.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "AuthorID")
    private Author author;

    /**
     * A flag or indicator determining if this author is the lead or primary contributor.
     */
    @Column(name = "PrimaryAuthor", length = 1)
    private String primaryAuthor;

    public BookAuthor() {
    	
    }

    public BookAuthor(Book book, Author author, String primaryAuthor) {
        this.book = book;
        this.author = author;
        this.primaryAuthor = primaryAuthor;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPrimaryAuthor() {
        return primaryAuthor;
    }

    public void setPrimaryAuthor(String primaryAuthor) {
        this.primaryAuthor = primaryAuthor;
    }
}
