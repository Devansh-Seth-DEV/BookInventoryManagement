package com.bookinventory.dto;

/**
 * Data Transfer Object providing a high-level summary of a professional reviewer's profile.
 * Used for populating reviewer directories and showing critic authority.
 */
public class AllReviewerResponseDTO {

    /**
     * The primary key uniquely identifying the reviewer in the system.
     */
    private Integer reviewerId;

    /**
     * The full name of the professional critic.
     */
    private String name;

    /**
     * The professional organization or media outlet the reviewer represents.
     */
    private String employedBy;

    /**
     * The cumulative number of critiques authored by this reviewer across the catalog.
     */
    private Long totalReviewCount;

    /**
     * The highest numerical score this reviewer has ever assigned to a title.
     */
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