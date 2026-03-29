package com.bookinventory.model;

import java.io.Serializable;
import java.util.Objects;

public class BookAuthorId implements Serializable {

	private String book;
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
