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
	@Query("SELECT b FROM Book b JOIN FETCH b.category JOIN FETCH b.publisher")
    List<Book> findAllWithDetails();
	
	@Query("""
	SELECT b
	FROM Book b
	JOIN FETCH b.category
	JOIN FETCH b.publisher
	WHERE b.isbn = :bookIsbn
	""")
	Optional<Book> findByIdWithDetails(@Param("bookIsbn") String bookIsbn);
	
	@Query("SELECT b FROM Book b JOIN FETCH b.category WHERE b.category.catId = :categoryId")
	List<Book> findAllByCategoryId(@Param("categoryId") Integer catId);
	
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
