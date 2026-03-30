package com.bookinventory.service;

import java.util.List;
import com.bookinventory.dto.AllReviewerResponseDTO;

public interface ReviewerService {
    List<AllReviewerResponseDTO> getAllReviewers();
}