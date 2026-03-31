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

    @Query("SELECT br FROM BookReview br JOIN FETCH br.book JOIN FETCH br.reviewer WHERE br.book.isbn = :isbn")
    List<BookReview> findByBookIsbnWithDetails(@Param("isbn") String isbn);
}