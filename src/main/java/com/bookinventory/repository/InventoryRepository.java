package com.bookinventory.repository;

import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    @Query("SELECT i FROM Inventory i JOIN FETCH i.book b JOIN FETCH i.bookCondition bc WHERE i.purchased = false")
    List<Inventory> findAvailableInventory();
}
