package com.bookinventory.service;

import java.util.List;

import com.bookinventory.dto.AllBookOfAuthorResponseDTO;
import com.bookinventory.model.Book;

public interface BookService {
	/**
     * Retrieves the entire collection of titles currently managed in the system.
     * @return List of all Book entities.
     */
    List<Book> getAllBooks();

    /**
     * Fetches metadata for a specific title using its unique ISBN identifier.
     * @param bookIsbn The unique 10 or 13-digit International Standard Book Number.
     * @return The matching Book entity, or null if no match is found.
     */
    Book getBookDetailsByIsbn(String bookIsbn);

    /**
     * Filters the catalog based on a specific genre or category identifier.
     * @param catId The primary key of the BookCategory.
     * @return A filtered list of Books belonging to the specified category.
     */
    List<Book> getAllBooksByCategoryId(Integer catId);

    /**
     * Retrieves all titles associated with a specific author, projected into a
     * specialized DTO for performance and frontend compatibility.
     * @param authorId The primary key of the Author.
     * @return List of AllBookOfAuthorResponseDTO containing book details and author context.
     */
    List<AllBookOfAuthorResponseDTO> getAllBookByAuthorId(Integer authorId);
}
