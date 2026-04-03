package com.bookinventory.service;

import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.dto.InventoryResponseDTO;
import com.bookinventory.dto.LowStockResponseDTO;
import com.bookinventory.model.Inventory;

import java.util.List;

public interface InventoryService {
	/**
     * Retrieves a list of all unique physical book copies currently available for purchase.
     * @return List of AvailableInventoryResponseDTO containing specific copy details.
     */
    List<AvailableInventoryResponseDTO> getAvailableInventory();

    /**
     * Fetches comprehensive data for a single physical asset via its unique Inventory ID.
     * * @param inventoryId The primary key identifying the unique physical asset.
     * @return InventoryResponseDTO containing the book's physical and metadata context.
     */
    InventoryResponseDTO getInventoryById(Integer inventoryId);

    /**
     * Identifies inventory items where the available quantity has fallen below the
     * safety threshold (Quantity < 5).
     * @return List of LowStockResponseDTO representing items requiring urgent restock.
     */
    List<LowStockResponseDTO> getLowStock();
}
