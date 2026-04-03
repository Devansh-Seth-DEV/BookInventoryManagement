package com.bookinventory.api;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookinventory.dto.AllReviewerResponseDTO;
import com.bookinventory.service.ReviewerService;

@RestController
@RequestMapping("/api/reviewers")
public class ReviewerController {

    @Autowired
    private ReviewerService reviewerService;

    private static final Logger log = LoggerFactory.getLogger(ReviewerController.class);

    /**
     * Retrieves a curated directory of all professional reviewers and critics.
     * @return ResponseEntity containing a list of AllReviewerResponseDTO.
     */
    @GetMapping
    public ResponseEntity<List<AllReviewerResponseDTO>> getAllReviewers() {
        log.info("Received request to list all reviewers");
        return ResponseEntity.ok(reviewerService.getAllReviewers());
    }
    
}