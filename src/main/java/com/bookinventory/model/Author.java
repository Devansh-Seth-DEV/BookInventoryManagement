package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorID")
    private Integer authorID;

    @Column(
    	name = "LastName", 
    	nullable = false,
    	length = 50
    )
    private String lastName;

    @Column(
    	name = "FirstName", 
    	nullable = false, 
    	length = 50
    )
    private String firstName;

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
        this.authorID = authorID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.photo = photo;
    }

    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
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


