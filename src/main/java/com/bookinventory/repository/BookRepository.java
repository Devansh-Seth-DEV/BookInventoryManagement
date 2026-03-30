package com.bookinventory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookinventory.model.Book;

@Repository
public interface BookRepository
	extends JpaRepository<Book, String>
{
	@Query("SELECT b FROM Book b JOIN FETCH b.category JOIN FETCH b.publisher")
    List<Book> findAllWithDetails();
	
	@Query("SELECT b FROM Book b " +
		   "JOIN FETCH b.category JOIN FETCH b.publisher " +
		   "WHERE LOWER(b.isbn) = LOWER(:bookIsbn)")
	Optional<Book> findByIdWithDetails(@Param("bookIsbn") String bookIsbn);
}
