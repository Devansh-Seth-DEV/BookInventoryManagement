package com.bookinventory.service;

import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.model.Inventory;

import java.util.List;

public interface InventoryService {
    List<AvailableInventoryResponseDTO> getAvailableInventory();
}
