package com.bookinventory.dto;

public class InventoryResponseDTO {
    private String isbn;
    private String bookTitle;
    private String conditionDescription;
    private String conditionFullDescription;
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
