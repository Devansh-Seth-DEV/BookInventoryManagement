package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Persistent entity representing a unique book title in the catalog.
 * Acts as the central anchor for Authors, Inventory units, and Reviews.
 * This model defines the metadata shared across all physical copies of a specific work.
 */
@Entity
@Table(name = "book")
public class Book {

    /**
     * The unique 13-character International Standard Book Number.
     * Serves as the natural primary key for the entity.
     */
    @Id
    @Column(name = "ISBN", length = 13)
    private String isbn;

    /**
     * The official title of the publication. 
     * Required field with a 70-character limit for optimized database indexing.
     */
    @Column(name = "Title", length = 70, nullable = false)
    private String title;

    /**
     * A brief synopsis or marketing blurb for the title.
     */
    @Column(name = "Description", length = 100)
    private String description;

    /**
     * The genre or classification associated with this book.
     * Established via a Many-to-One relationship to the Category entity.
     */
    @ManyToOne
    @JoinColumn(name = "Category")
    private Category category;

    /**
     * The specific release version or printing of the book.
     */
    @Column(name = "Edition", length = 30)
    private String edition;

    /**
     * The entity responsible for the book's production and distribution.
     * Mandatory association representing the link to the Publisher table.
     */
    @ManyToOne
    @JoinColumn(name = "PublisherID", nullable = false)
    private Publisher publisher;

    public Book() {
    }

    public Book(
            String isbn,
            String title,
            String description,
            Category category,
            String edition,
            Publisher publisher
    ) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.category = category;
        this.edition = edition;
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}