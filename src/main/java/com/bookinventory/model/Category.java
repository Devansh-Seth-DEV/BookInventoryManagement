package com.bookinventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "CatID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer catId;

    @Column(name = "CatDescription", length = 24)
    private String catDescription;

    public Category() {}

    public Category(Integer catId, String catDescription) {
        this.catId = catId;
        this.catDescription = catDescription;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

}
