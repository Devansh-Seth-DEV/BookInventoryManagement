package com.bookinventory.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookinventory.dto.AllReviewerResponseDTO;
import com.bookinventory.model.Reviewer;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Integer> {

    @Query("""
            SELECT 
            	NEW com.bookinventory.dto.AllReviewerResponseDTO(
            		r.reviewerId,
            		r.name,
            		r.employedBy,
            		COUNT(br),
            		MAX(br.rating)
            	)
            from Reviewer r
            LEFT JOIN BookReview br ON br.reviewer.reviewerId = r.reviewerId
            GROUP BY r.reviewerId, r.name, r.employedBy
            ORDER BY r.name
            """)
    List<AllReviewerResponseDTO> findAllReviewersWithStats();
}