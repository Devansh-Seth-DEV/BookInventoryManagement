package com.bookinventory.dto;

/**
 * Data Transfer Object containing user credentials for authentication.
 * Used as the secure payload for the login entry point.
 */
public class LoginRequestDTO {

    /**
     * The unique identifier or email address chosen by the user.
     */
    private String username;

    /**
     * The secret character string used to verify the user's identity.
     */
    private String password;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}