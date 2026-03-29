package com.bookinventory.dto.converter;

import com.bookinventory.dto.AllReviewerResponseDTO;
public class AllReviewerResponseConverter {
    public static AllReviewerResponseDTO convert(Object[] row) {

        Integer reviewerId = (Integer) row[0];
        String name = (String) row[1];
        String employedBy = (String) row[2];
        Long reviewCount = (Long) row[3];

        Integer maxRating = row[4] == null ? 0 : ((Number) row[4]).intValue();

        return new AllReviewerResponseDTO(
                reviewerId,
                name,
                employedBy,
                reviewCount,
                maxRating
        );
    }
}