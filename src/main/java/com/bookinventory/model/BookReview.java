package com.bookinventory.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviewer")
public class Reviewer {

    @Id
    @Column(name = "ReviewerID")
    private Integer reviewerID;

    @Column(name = "Name")
    private String name;

    @Column(name = "EmployedBy")
    private String employedBy;

    @OneToMany(mappedBy = "reviewer")
    private List<BookReview> reviews;

    public Reviewer() {}
}