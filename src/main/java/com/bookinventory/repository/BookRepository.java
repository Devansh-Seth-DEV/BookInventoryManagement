package com.bookinventory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookinventory.dto.AllBookOfAuthorResponseDTO;
import com.bookinventory.model.Book;

@Repository
public interface BookRepository
	extends JpaRepository<Book, String>
{
	/**
     * Retrieves all books with Category and Publisher data eagerly loaded.
     * Uses JOIN FETCH to prevent the N+1 select problem.
     * @return A list of Book entities with initialized associations.
     */
	@Query("SELECT b FROM Book b JOIN FETCH b.category JOIN FETCH b.publisher")
    List<Book> findAllWithDetails();
	
	/**
     * Retrieves a single book by ISBN with its associated Category and Publisher.
     * Optimized for detail views to ensure all metadata is available in a single trip.
     * @param bookIsbn The unique ISBN of the book.
     * @return An Optional containing the fully initialized Book entity.
     */
	@Query("""
	SELECT b
	FROM Book b
	JOIN FETCH b.category
	JOIN FETCH b.publisher
	WHERE b.isbn = :bookIsbn
	""")
	Optional<Book> findByIdWithDetails(@Param("bookIsbn") String bookIsbn);
	
	/**
     * Fetches all books belonging to a specific category ID.
     * @param catId The primary key of the Category entity.
     * @return A list of books filtered by the provided category.
     */
	@Query("SELECT b FROM Book b JOIN FETCH b.category WHERE b.category.catId = :categoryId")
	List<Book> findAllByCategoryId(@Param("categoryId") Integer catId);
	
	/**
     * Projects book and author data directly into a DTO for high-performance reporting.
     * Uses a Constructor Expression to avoid loading full entities into memory.
     * @param authorId The primary key of the Author entity.
     * @return A list of AllBookOfAuthorResponseDTO objects.
     */
	@Query("""
	SELECT
		NEW com.bookinventory.dto.AllBookOfAuthorResponseDTO(
			ba.book.isbn,
			ba.book.title,
			ba.author.firstName,
			ba.author.lastName,
			ba.book.publisher.name
		)
	FROM BookAuthor ba
	WHERE ba.author.authorId = :authorId
	""")
	List<AllBookOfAuthorResponseDTO> findAllByAuthorId(Integer authorId);
}
