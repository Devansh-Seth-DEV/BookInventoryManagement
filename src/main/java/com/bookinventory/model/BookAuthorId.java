package com.bookinventory.model;

import java.io.Serializable;
import java.util.Objects;

public class BookAuthorId implements Serializable {

    private String isbn;
    private Integer author;

    public BookAuthorId() {}

    public BookAuthorId(String isbn, Integer author) {
        this.isbn = isbn;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookAuthorId that = (BookAuthorId) o;
        return Objects.equals(isbn, that.isbn) &&
                Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, author);
    }
}
