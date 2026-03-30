package com.bookinventory.service;

import com.bookinventory.dto.converter.AvailableInventoryResponseConverter;
import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.exception.ResourceNotFoundException;
import com.bookinventory.model.Inventory;
import com.bookinventory.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{

    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private AvailableInventoryResponseConverter availableInventoryResponseConverter;

    @Override
    public List<AvailableInventoryResponseDTO> getAvailableInventory() {

        log.info("Fetching all physical copies of books in stock");

        List<Inventory> inventoryList = inventoryRepository.findAvailableInventory();
        if (inventoryList == null || inventoryList.isEmpty()) {
            String message = "Stock is empty";
            log.warn(message);
            throw new ResourceNotFoundException(message);
        }
        log.info("Successfully fetched all the books from the book repository");
        return inventoryList.stream().map(availableInventoryResponseConverter::convert).toList();
    }
}
