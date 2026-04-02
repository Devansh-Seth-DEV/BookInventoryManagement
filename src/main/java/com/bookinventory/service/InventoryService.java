package com.bookinventory.service;

import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.dto.InventoryResponseDTO;

import java.util.List;

public interface InventoryService {

    List<AvailableInventoryResponseDTO> getAvailableInventory();

    InventoryResponseDTO getInventoryById(Integer inventoryId);
}
