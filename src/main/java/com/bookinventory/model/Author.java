package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Persistent entity representing a book author.
 * This model maps to the 'author' table and serves as a primary 
 * metadata source for cataloging and search indexing.
 */
@Entity
@Table(name = "author")
public class Author {
    
    /**
     * Unique internal identifier for the author, automatically incremented by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorID")
    private Integer authorId;

    /**
     * The author's family name. Required field with a 50-character limit for database optimization.
     */
    @Column(
    	name = "LastName", 
    	nullable = false,
    	length = 50
    )
    private String lastName;

    /**
     * The author's given name. Required field used for sorting and display in the UI.
     */
    @Column(
    	name = "FirstName", 
    	nullable = false, 
    	length = 50
    )
    private String firstName;

    /**
     * A reference path or flag for the author's profile image.
     */
    @Column(name = "Photo", length = 1)
    private String photo;

    public Author() {
    }

    public Author(
    	String lastName, 
    	String firstName, 
    	String photo
    ) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.photo = photo;
    }

    public Author(
    	Integer authorID, 
    	String lastName, 
    	String firstName, 
    	String photo
    ) {
        this.authorId = authorID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.photo = photo;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorID) {
        this.authorId = authorID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


}


