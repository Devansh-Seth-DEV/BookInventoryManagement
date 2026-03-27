package com.bookinventory.model;

import java.io.Serializable;
import java.util.Objects;

public class ShoppingCartId implements Serializable {

    private Integer user;
    private String book;

    public ShoppingCartId() {
    }

    public ShoppingCartId(
            Integer user,
            String book
    ) {
        this.user = user;
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShoppingCartId)) {
            return false;
        }
        ShoppingCartId that = (ShoppingCartId) o;
        return Objects.equals(user, that.user) && 
               Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, book);
    }
}