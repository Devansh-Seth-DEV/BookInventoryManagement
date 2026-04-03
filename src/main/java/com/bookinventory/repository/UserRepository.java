package com.bookinventory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookinventory.dto.UserPurchaseDTO;
import com.bookinventory.dto.UserResponseDTO;
import com.bookinventory.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	/**
     * Retrieves a summarized user profile including their security role.
     * Projects directly into a UserResponseDTO to ensure sensitive internal data (like passwords) 
     * is never loaded or exposed to the frontend.
     * @param userId The unique primary key of the user.
     * @return An Optional containing the lightweight user profile summary.
     */	
	@Query("""
	        SELECT 
	            NEW com.bookinventory.dto.UserResponseDTO(
	                u.firstName,
	                u.lastName,
	                u.userName,
	                u.phoneNumber,
	                r.permRole
	            )
	        FROM User u JOIN u.permRole r
	        WHERE u.userId = :userId
	        """)
	Optional<UserResponseDTO> getUserProfileById(Integer userId);
	
	/**
     * Aggregates a user's complete purchase history by traversing the audit log.
     * Joins the PurchaseLog, Inventory, and Book metadata to provide a comprehensive receipt view.
     * @param userId The unique primary key of the customer.
     * @return A list of UserPurchaseDTOs representing every confirmed transaction.
     */
	@Query("""
		SELECT
			NEW com.bookinventory.dto.UserPurchaseDTO(
				inv.inventoryId,
				b.isbn,
				b.title,
				bc.price,
				bc.description
			)
		FROM PurchaseLog plog
		JOIN plog.inventory inv
		JOIN inv.book b
		JOIN inv.bookCondition bc
		WHERE plog.user.userId = :userId 
		AND inv.purchased = true
	""")
	List<UserPurchaseDTO> getPurchaseHistoryByUserId(Integer userId);
	
	/**
     * Standard derived query for authentication.
     * Used by the security layer to fetch the full User entity for credential verification.
     * @param userName The unique login identifier.
     * @return The complete User entity, or null if not found.
     */
	User findByUserName(String userName);
}
