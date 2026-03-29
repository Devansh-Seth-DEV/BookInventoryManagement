package com.bookinventory.service;

import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<AvailableInventoryResponseDTO> getAvailableInventory() {
        return inventoryRepository.findAvailableInventory();
    }
}
