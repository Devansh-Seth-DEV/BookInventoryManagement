package com.bookinventory.dto;

/**
 * Data Transfer Object containing the result of an authentication attempt.
 * Provides the security token required for subsequent authorized API calls.
 */
public class LoginResponseDTO {

    /**
     * The Bearer token (JWT or similar) used for identity verification in headers.
     */
    private String token;

    /**
     * A human-readable status message confirming success or explaining a login issue.
     */
    private String message;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
