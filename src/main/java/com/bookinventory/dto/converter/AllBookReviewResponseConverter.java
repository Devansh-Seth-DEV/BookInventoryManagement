package com.bookinventory.dto.converter;

import com.bookinventory.dto.AllBookReviewResponseDTO;
import com.bookinventory.model.BookReview;

public class AllBookReviewResponseConverter {

    public static AllBookReviewResponseDTO convert(BookReview review) {
    	String reviewerName = "Anonymous";
    	String employedBy = "Freelance";
    	String isbn = "null";
    	
    	if (review.getReviewer() != null) {
    		reviewerName = review.getReviewer().getName();
    		employedBy = review.getReviewer().getEmployedBy();
    	}
    	
    	if (review.getBook() != null) {
    		isbn = review.getBook().getIsbn();
    	}

        AllBookReviewResponseDTO dto = new AllBookReviewResponseDTO(
					review.getBook().getIsbn(),
					reviewerName,
					review.getRating(),
					review.getComments(),
					employedBy
        		);
        
        return dto;
    }
}