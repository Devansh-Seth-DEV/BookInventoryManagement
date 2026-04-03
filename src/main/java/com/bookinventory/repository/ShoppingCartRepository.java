package com.bookinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookinventory.dto.UserCartResponseDTO;
import com.bookinventory.model.ShoppingCart;
import com.bookinventory.model.ShoppingCartId;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartId> {
	/**
     * Retrieves all items currently held in a specific user's shopping cart.
     * Projects directly into a UserCartResponseDTO, pulling metadata from the 
     * Book and Publisher entities to minimize frontend overhead.
     * @param userId The unique primary key of the customer.
     * @return A list of lightweight cart summary objects for the UI.
     */
	@Query("""
	        SELECT
	            NEW com.bookinventory.dto.UserCartResponseDTO(
	                b.isbn,
	                b.title,
	                b.edition,
	                p.name
	            )
	        FROM ShoppingCart sc
	        JOIN sc.book b
	        JOIN b.publisher p
	        WHERE sc.user.userId = :userId
	        """)
	List<UserCartResponseDTO> getUserCartByUserId(Integer userId);
}