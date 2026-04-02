package com.bookinventory.service;

import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.dto.InventoryResponseDTO;
import com.bookinventory.dto.LowStockResponseDTO;
import com.bookinventory.model.Inventory;

import java.util.List;

public interface InventoryService {

    List<AvailableInventoryResponseDTO> getAvailableInventory();

    InventoryResponseDTO getInventoryById(Integer inventoryId);

    List<LowStockResponseDTO> getLowStock();
}
