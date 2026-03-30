package com.bookinventory.repository;

import com.bookinventory.dto.InventoryResponseDTO;
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
}
