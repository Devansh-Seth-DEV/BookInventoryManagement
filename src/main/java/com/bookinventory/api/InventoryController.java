package com.bookinventory.api;


import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.dto.InventoryResponseDTO;
import com.bookinventory.dto.LowStockResponseDTO;
import com.bookinventory.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private static final Logger log = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryService inventoryService;

    /**
     * Retrieves all unique physical book copies currently available for purchase.
     * @return ResponseEntity containing a list of AvailableInventoryResponseDTO.
     */
    @GetMapping("/available")
    public ResponseEntity<List<AvailableInventoryResponseDTO>> getAvailableInventory(){
        log.info("Requesting Endpoint(/api/inventory/available) to fetch all physical copies in stock");
        List<AvailableInventoryResponseDTO> availableInventory = inventoryService.getAvailableInventory();
        return new ResponseEntity<>(availableInventory, HttpStatus.OK);
    }

    /**
     * Fetches comprehensive data for a single physical asset via its inventory identifier.
     * @param inventoryId The primary key identifying the unique physical asset.
     * @return ResponseEntity containing the InventoryResponseDTO.
     */
    @GetMapping("/{inventoryId}")
    public ResponseEntity<InventoryResponseDTO> getInventoryById(
            @PathVariable Integer inventoryId) {
        log.info("Requesting Endpoint(/api/inventory/{inventoryId}) to fetch a physical copy of a particular Inventory");
        InventoryResponseDTO inventory = inventoryService.getInventoryById(inventoryId);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }
    
    /**
     * Identifies inventory items where the stock level has fallen below the safety threshold.
     * @return ResponseEntity containing a list of LowStockResponseDTO for administrative review.
     */
    @GetMapping("/low-stock")
    public ResponseEntity<List<LowStockResponseDTO>> getLowStockBooks() {
        return new ResponseEntity<>(inventoryService.getLowStock(),HttpStatus.OK);
    }
}
