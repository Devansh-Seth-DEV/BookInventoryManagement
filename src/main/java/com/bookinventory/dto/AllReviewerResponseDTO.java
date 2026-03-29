package com.bookinventory.dto;

public class AllReviewerResponseDTO {
    private Integer reviewerId;
    private String name;
    private String employedBy;
    private Long totalReviewCount;
    private Integer maxRating;

    public AllReviewerResponseDTO() {
    }

    public AllReviewerResponseDTO(
            Integer reviewerId,
            String name,
            String employedBy,
            Long totalReviewCount,
            Integer maxRating
    ) {
        this.reviewerId = reviewerId;
        this.name = name;
        this.employedBy = employedBy;
        this.totalReviewCount = totalReviewCount;
        this.maxRating = maxRating;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public String getName() {
        return name;
    }

    public String getEmployedBy() {
        return employedBy;
    }

    public Long getTotalReviewCount() {
        return totalReviewCount;
    }

    public Integer getMaxRating() {
        return maxRating;
    }
}