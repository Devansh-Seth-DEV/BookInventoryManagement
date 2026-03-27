package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "ISBN",
            length = 13
    )
    private String isbn;

    @Column(
    	name = "Title",
    	length = 70, 
    	nullable = false
    )
    private String title;

    @Column(name = "Description",
            length = 100
    )
    private String description;

    @ManyToOne
    @JoinColumn(name = "Category")
    private Category category;

    @Column(
            name = "Edition",
            length = 30
    )
    private String edition;

    @ManyToOne
    @JoinColumn(
            name = "PublisherID",
            nullable = false
    )
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