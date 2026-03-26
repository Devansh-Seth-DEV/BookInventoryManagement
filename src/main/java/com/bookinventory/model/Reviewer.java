package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviewer")
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewerID")
    private Integer reviewerId;

    @Column(name = "Name", nullable = false, length = 20)
    private String name;

    @Column(name = "EmployedBy", length = 30)
    private String employedBy;

    public Reviewer() {
    }

    public Reviewer(
            Integer reviewerId,
            String name,
            String employedBy
    ) {
        this.reviewerId = reviewerId;
        this.name = name;
        this.employedBy = employedBy;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployedBy() {
        return employedBy;
    }

    public void setEmployedBy(String employedBy) {
        this.employedBy = employedBy;
    }
}