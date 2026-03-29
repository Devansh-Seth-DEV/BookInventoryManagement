package com.bookinventory.repository;

import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    @Query("SELECT new com.example.dto.AvailableInventoryResponseDTO(" +
            "b.isbn, b.title, bc.description, i.price) " +
            "FROM Inventory i " +
            "JOIN i.book b " +
            "JOIN i.bookCondition bc " +
            "WHERE i.purchased = 0")
    List<AvailableInventoryResponseDTO> findAvailableInventory();
}
