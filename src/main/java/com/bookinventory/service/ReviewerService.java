package com.bookinventory.service;

import java.util.List;

import com.bookinventory.dto.AllReviewerResponseDTO;
import com.bookinventory.model.BookReview;

public interface ReviewerService {
	/**
     * Retrieves a curated list of all professional reviewers and critics 
     * registered in the system.
     * @return List of AllReviewerResponseDTO containing reviewer profiles and credentials.
     */
    List<AllReviewerResponseDTO> getAllReviewers();

    /**
     * Fetches all critical reviews and ratings associated with a specific 
     * book title via its ISBN.
     * @param isbn The unique International Standard Book Number for the title.
     * @return List of BookReview entities containing scores and qualitative feedback.
     */
    List<BookReview> getReviewsByBookIsbn(String isbn);
}	