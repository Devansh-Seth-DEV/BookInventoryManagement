package com.bookinventory.service;

import java.util.List;

import com.bookinventory.dto.UserCartResponseDTO;

public interface ShoppingCartService {

	/**
     * Retrieves the active shopping cart and all pending items for a specific user.
     * @param userId The primary key identifying the unique user.
     * @return List of UserCartResponseDTO containing book details and copy specifics.
     */
    List<UserCartResponseDTO> getUserCart(Integer userId);;
}