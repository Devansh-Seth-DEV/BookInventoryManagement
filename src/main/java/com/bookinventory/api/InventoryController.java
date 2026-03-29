package com.bookinventory.api;


import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/available")
    public ResponseEntity<List<AvailableInventoryResponseDTO>> getAvailableInventory(){
        List<AvailableInventoryResponseDTO> availableInventory = inventoryService.getAvailableInventory();
        return new ResponseEntity<List<AvailableInventoryResponseDTO>>(availableInventory, HttpStatus.OK);
    }

}
