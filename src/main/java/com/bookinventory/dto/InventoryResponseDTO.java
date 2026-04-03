package com.bookinventory.dto;

/**
 * Data Transfer Object representing the granular details of a specific physical book copy.
 * Used for administrative tracking and detailed condition reporting of individual inventory units.
 */
public class InventoryResponseDTO {

    /**
     * The unique International Standard Book Number associated with this physical unit.
     */
    private String isbn;

    /**
     * The official title of the book corresponding to the ISBN.
     */
    private String bookTitle;

    /**
     * A brief, high-level summary of the item's physical state (e.g., "Like New").
     */
    private String conditionDescription;

    /**
     * A comprehensive narrative detailing specific wear, tear, or unique attributes of this copy.
     */
    private String conditionFullDescription;

    /**
     * A flag indicating whether this specific unit has already been sold (True) or remains in stock (False).
     */
    private Boolean purchasedStatus;

    public InventoryResponseDTO(String isbn,
                                String bookTitle,
                                String conditionDescription,
                                String conditionFullDescription,
                                Boolean purchasedStatus) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.conditionDescription = conditionDescription;
        this.conditionFullDescription = conditionFullDescription;
        this.purchasedStatus = purchasedStatus;
    }

    public InventoryResponseDTO() {}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getConditionFullDescription() {
        return conditionFullDescription;
    }

    public void setConditionFullDescription(String conditionFullDescription) {
        this.conditionFullDescription = conditionFullDescription;
    }

    public Boolean getPurchasedStatus() {
        return purchasedStatus;
    }

    public void setPurchasedStatus(Boolean purchasedStatus) {
        this.purchasedStatus = purchasedStatus;
    }
}
