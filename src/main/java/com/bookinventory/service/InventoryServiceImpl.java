package com.bookinventory.service;

import com.bookinventory.api.InventoryController;
import com.bookinventory.dto.AvailableInventoryResponseConverter;
import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.model.Inventory;
import com.bookinventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private AvailableInventoryResponseConverter availableInventoryResponseConverter;

    @Override
    public List<AvailableInventoryResponseDTO> getAvailableInventory() {

        List<Inventory> inventoryList = inventoryRepository.findAvailableInventory();
        return inventoryList.stream().map(availableInventoryResponseConverter::convert).toList();
    }
}
