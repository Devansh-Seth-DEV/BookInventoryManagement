package com.bookinventory.service;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookinventory.dto.AllReviewerResponseDTO;
import com.bookinventory.dto.converter.AllReviewerResponseConverter;
import com.bookinventory.exception.ResourceNotFoundException;
import com.bookinventory.repository.ReviewerRepository;

@Service
public class ReviewerServiceImpl implements ReviewerService {

    @Autowired
    private ReviewerRepository reviewerRepo;

    private static final Logger log = LoggerFactory.getLogger(ReviewerServiceImpl.class);

    @Override
    public List<AllReviewerResponseDTO> getAllReviewers() {
        log.info("Fetching all reviewers with stats from the repository");

        List<Object[]> results = reviewerRepo.findAllReviewersWithStats();

        if (results == null || results.isEmpty()) {
            String message = "No reviewers found in the system.";
            log.warn(message);
            throw new ResourceNotFoundException(message);
        }

        log.info("Successfully fetched {} reviewers", results.size());
        
        return results.stream()
                .map(AllReviewerResponseConverter::convert)
                .collect(Collectors.toList());
    }
}