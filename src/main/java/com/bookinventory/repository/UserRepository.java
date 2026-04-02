package com.bookinventory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookinventory.dto.UserPurchaseDTO;
import com.bookinventory.dto.UserResponseDTO;
import com.bookinventory.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
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
}
