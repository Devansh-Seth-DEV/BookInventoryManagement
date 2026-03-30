package com.bookinventory.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.bookinventory.api.ReviewerController;
import com.bookinventory.dto.AllReviewerResponseDTO;
import com.bookinventory.exception.ResourceNotFoundException;
import com.bookinventory.service.ReviewerService;

@WebMvcTest(ReviewerController.class)
class ReviewerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ReviewerService reviewerService;

    private static final Logger log = LoggerFactory.getLogger(ReviewerControllerTest.class);
    
    private AllReviewerResponseDTO mockReviewer;

    @BeforeEach
    void setup() {
        
        mockReviewer = new AllReviewerResponseDTO(
                3,
                "Bills",
                "The RIT Reporter",
                1L,
                4
        );
    }

    @Test
    void testGetAllReviewers_Success() throws Exception {
        log.info("Testing getAllReviewers() for 200-OK Status");

        List<AllReviewerResponseDTO> reviewers = new ArrayList<>();
        reviewers.add(mockReviewer);

        when(reviewerService.getAllReviewers()).thenReturn(reviewers);

        mockMvc.perform(
                get("/api/reviewers")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].reviewerId").value(3))
            .andExpect(jsonPath("$[0].name").value("Bills"))
            .andExpect(jsonPath("$[0].maxRating").value(4))
            .andDo(result -> 
                log.info("Test Result: " + result.getResponse().getContentAsString())
            );
    }

    @Test
    void testGetAllReviewers_NotFound() throws Exception {
        log.info("Testing getAllReviewers() for 404-Not Found Status");

        String message = "No reviewers were found in the system.";
        when(reviewerService.getAllReviewers())
                .thenThrow(new ResourceNotFoundException(message));

        mockMvc.perform(
                get("/api/reviewers")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value(message))
            .andExpect(jsonPath("$.status").value(404))
            .andDo(result -> 
                log.error("Test Result: " + result.getResponse().getContentAsString())
            );
    }
}