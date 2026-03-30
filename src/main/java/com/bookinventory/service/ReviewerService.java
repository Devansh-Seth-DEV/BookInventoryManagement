package com.bookinventory.service;

import java.util.List;

import com.bookinventory.dto.AllReviewerResponseDTO;
import com.bookinventory.model.BookReview;

public interface ReviewerService {
    List<AllReviewerResponseDTO> getAllReviewers();
    
    List<BookReview> getReviewsByBookIsbn(String isbn);
}	