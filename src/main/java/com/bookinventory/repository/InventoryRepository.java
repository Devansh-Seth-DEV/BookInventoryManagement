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
    @Query("SELECT i FROM Inventory i JOIN FETCH i.book b JOIN FETCH i.bookCondition bc WHERE i.purchased = false")
    List<Inventory> findAvailableInventory();

    @Query("SELECT i FROM Inventory i JOIN FETCH i.book b JOIN FETCH i.bookCondition bc WHERE i.inventoryId = :inventoryId")
    Optional<Inventory> findInventoryById(@Param("inventoryId") Integer inventoryId);

    @Query("SELECT new com.bookinventory.dto.LowStockResponseDTO(b.isbn, b.title, COUNT(i)) FROM Inventory i JOIN i.book b WHERE i.purchased = false GROUP BY b.isbn, b.title HAVING COUNT(i) < 5")
    List<LowStockResponseDTO> findLowStockBooks();
}
