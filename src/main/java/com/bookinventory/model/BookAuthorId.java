package com.bookinventory.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Composite Key class representing the unique pairing of a Book and an Author.
 * Implements Serializable to comply with JPA requirements for composite primary keys
 * in many-to-many join tables.
 */
public class BookAuthorId implements Serializable {

    /**
     * The ISBN of the book, acting as the first half of the composite identifier.
     */
	private String book;

    /**
     * The unique ID of the author, acting as the second half of the composite identifier.
     */
	private Integer author;

	public BookAuthorId() {
	}

	public BookAuthorId(String book, 
						Integer author
			) {
				this.book = book;
				this.author = author;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		BookAuthorId that = (BookAuthorId) o;
		return Objects.equals(book, that.book) && 
				Objects.equals(author, that.author);
	}

	@Override
	public int hashCode() {
		return Objects.hash(book, author);
	}
}
