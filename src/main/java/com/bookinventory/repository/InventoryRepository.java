package com.bookinventory.repository;

import com.bookinventory.dto.InventoryResponseDTO;
import com.bookinventory.dto.LowStockResponseDTO;
import com.bookinventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	/**
     * Retrieves all physical book units currently in stock (not yet purchased).
     * Eagerly loads Book and Condition metadata to provide a comprehensive storefront view.
     * @return A list of available Inventory units with initialized associations.
     */
    @Query("SELECT i FROM Inventory i JOIN FETCH i.book b JOIN FETCH i.bookCondition bc WHERE i.purchased = false")
    List<Inventory> findAvailableInventory();

    /**
     * Fetches a specific inventory unit by its unique primary key.
     * Uses JOIN FETCH to ensure condition details and book metadata are loaded in a single transaction.
     * @param inventoryId The unique internal ID for the physical book copy.
     * @return An Optional containing the fully initialized Inventory entity.
     */
    @Query("SELECT i FROM Inventory i JOIN FETCH i.book b JOIN FETCH i.bookCondition bc WHERE i.inventoryId = :inventoryId")
    Optional<Inventory> findInventoryById(@Param("inventoryId") Integer inventoryId);

    /**
     * Identifies titles with critically low stock levels (less than 5 units).
     * Projects results directly into a LowStockResponseDTO for administrative reporting.
     * @return A list of DTOs containing ISBNs, titles, and current stock counts.
     */
    @Query("SELECT new com.bookinventory.dto.LowStockResponseDTO(b.isbn, b.title, COUNT(i)) FROM Inventory i JOIN i.book b WHERE i.purchased = false GROUP BY b.isbn, b.title HAVING COUNT(i) < 5")
    List<LowStockResponseDTO> findLowStockBooks();
}
