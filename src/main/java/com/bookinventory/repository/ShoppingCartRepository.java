package com.bookinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookinventory.dto.UserCartResponseDTO;
import com.bookinventory.model.ShoppingCart;
import com.bookinventory.model.ShoppingCartId;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartId> {

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