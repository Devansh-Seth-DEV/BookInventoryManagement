package com.bookinventory.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookcondition")
public class BookCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ranks")
    private Integer ranks;

    @Column(name = "Description", length = 50)
    private String description;

    @Column(name = "FullDescription", length = 255)
    private String fullDescription;

    @Column(name = "Price", precision = 12, scale = 2)
    private BigDecimal price = new BigDecimal("30.00");

    public BookCondition() {
    }

    public BookCondition(
            Integer ranks,
            String description,
            String fullDescription,
            BigDecimal price
    ) {
        this.ranks = ranks;
        this.description = description;
        this.fullDescription = fullDescription;
        this.price = price;
    }

    public Integer getRanks() {
        return ranks;
    }

    public void setRanks(Integer ranks) {
        this.ranks = ranks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}