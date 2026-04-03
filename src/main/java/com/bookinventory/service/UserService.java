package com.bookinventory.service;

import java.util.List;

import com.bookinventory.dto.UserPurchaseDTO;
import com.bookinventory.dto.UserResponseDTO;
import com.bookinventory.model.User;

public interface UserService {
	/**
     * Retrieves the core profile information for a specific registered user.
     * @param userId The primary key of the User entity.
     * @return UserResponseDTO containing user credentials and profile details.
     */
    UserResponseDTO getUserProfile(Integer userId);

    /**
     * Retrieves the complete historical audit trail of all physical assets purchased by a user.
     * @param userId The primary key of the User entity.
     * @return List of UserPurchaseDTO containing past transaction data and copy specifics.
     */
    List<UserPurchaseDTO> getPurchaseHistoryByUserId(Integer userId);

    /**
     * Authenticates a user based on unique credentials to establish a secure session.
     * @param username The unique login identifier for the user.
     * @param password The secret credential associated with the account.
     * @return The authenticated User entity if credentials match.
     */
    User login(String username, String password);

    /**
     * Registers a new user within the system and persists their security profile.
     * @param user The User entity containing registration details and assigned roles.
     * @return The newly persisted User entity including generated identifiers.
     */
    User createUser(User user);
}