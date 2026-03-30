package com.bookinventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookinventory.dto.AllBookReviewResponseDTO;
import com.bookinventory.dto.AllReviewerResponseDTO;
import com.bookinventory.dto.converter.AllBookReviewResponseConverter;
import com.bookinventory.exception.ResourceNotFoundException;
import com.bookinventory.model.BookReview;
import com.bookinventory.repository.BookReviewRepository;
import com.bookinventory.repository.ReviewerRepository;

@Service
public class ReviewerServiceImpl implements ReviewerService {

    @Autowired
    private ReviewerRepository reviewerRepo;
    
    @Autowired
    private BookReviewRepository bookReviewRepository;

    private static final Logger log = LoggerFactory.getLogger(ReviewerServiceImpl.class);

    @Override
    public List<AllReviewerResponseDTO> getAllReviewers() {
        log.info("Fetching all reviewers with stats from the repository");

        List<AllReviewerResponseDTO> results = reviewerRepo.findAllReviewersWithStats();

        if (results == null || results.isEmpty()) {
            String message = "No reviewers found in the system.";
            log.warn(message);
            throw new ResourceNotFoundException(message);
        }

        log.info("Successfully fetched {} reviewers", results.size());
        
        return results;
        
        
    }
    
    @Override
    public List<AllBookReviewResponseDTO> getReviewsByBookIsbn(String isbn) {
        log.info("Fetching all reviews for Book ISBN: {}", isbn);

        List<BookReview> reviews = bookReviewRepository.findByBookIsbnWithDetails(isbn);

        if (reviews == null || reviews.isEmpty()) {
            String message = "No reviews found for Book ISBN: " + isbn;
            log.warn(message);
            throw new ResourceNotFoundException(message);
        }

        log.info("Successfully fetched {} reviews for ISBN: {}", reviews.size(), isbn);

        return reviews.stream()
                .map(AllBookReviewResponseConverter::convert)
                .collect(Collectors.toList());
    }
}