package com.bookinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookinventory.model.Book;

@Repository
public interface BookRepository
	extends JpaRepository<Book, String>
{
	@Query("SELECT b FROM Book b JOIN FETCH b.category JOIN FETCH b.publisher")
    List<Book> findAllWithDetails();
}
