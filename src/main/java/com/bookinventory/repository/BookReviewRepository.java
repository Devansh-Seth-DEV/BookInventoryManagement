package com.bookinventory.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bookinventory.model.BookReview;
import com.bookinventory.model.BookReviewId;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, BookReviewId> {
	/**
     * Retrieves all critiques for a specific title, eagerly loading both Book and Reviewer metadata.
     * Uses JOIN FETCH to prevent N+1 select issues when displaying reviewer affiliations or book titles.
     * @param isbn The unique International Standard Book Number.
     * @return A list of BookReview entities with fully initialized associations.
     */
    @Query("SELECT br FROM BookReview br JOIN FETCH br.book JOIN FETCH br.reviewer WHERE br.book.isbn = :isbn")
    List<BookReview> findByBookIsbnWithDetails(@Param("isbn") String isbn);
}