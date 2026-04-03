package com.bookinventory.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookinventory.dto.AllReviewerResponseDTO;
import com.bookinventory.model.Reviewer;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Integer> {

	/**
     * Retrieves all registered reviewers along with their historical performance metrics.
     * Projects directly into a DTO using aggregate functions (COUNT, MAX) to calculate 
     * total review volume and highest rating given.
     * Uses a LEFT JOIN to ensure reviewers with zero reviews are still included in the directory.
     * @return A list of AllReviewerResponseDTOs sorted alphabetically by name.
     */
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