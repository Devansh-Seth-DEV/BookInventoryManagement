package com.bookinventory.dto.converter;

import com.bookinventory.dto.AllBookReviewResponseDTO;
import com.bookinventory.model.BookReview;

public class AllBookReviewResponseConverter {

    public static AllBookReviewResponseDTO convert(BookReview review) {
        AllBookReviewResponseDTO dto = new AllBookReviewResponseDTO(
                review.getBook().getIsbn(),
                review.getReviewer() != null ? review.getReviewer().getName() : "Anonymous",
                review.getRating(),
                review.getComments(),
                review.getReviewer() != null ? review.getReviewer().getEmployedBy() : "Freelance"
        );
        
        return dto;
    }
}