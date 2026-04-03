package com.bookinventory.dto;

/**
 * Data Transfer Object representing the public-facing profile of a registered user.
 * Used for populating user dashboards and administrative account lists.
 */
public class UserResponseDTO {

    /**
     * The legal first name of the registered user.
     */
    private String firstName;

    /**
     * The legal last name or surname of the registered user.
     */
    private String lastName;

    /**
     * The unique login identifier chosen by the user for the platform.
     */
    private String userName;

    /**
     * The primary contact number associated with the user's account.
     */
    private String phoneNumber;

    /**
     * The security classification or privilege level (e.g., ADMIN, CUSTOMER).
     */
    private String roleName;

    public UserResponseDTO() {
    }

    public UserResponseDTO(String firstName, String lastName, String userName, String phoneNumber, String roleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.roleName = roleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}