package com.bookinventory.service;

import com.bookinventory.dto.converter.AvailableInventoryResponseConverter;
import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.model.Inventory;
import com.bookinventory.repository.InventoryRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryServiceImplTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @Mock
    private AvailableInventoryResponseConverter converter;

    @InjectMocks
    private InventoryServiceImpl inventoryService;

    private Inventory inventory;
    private AvailableInventoryResponseDTO dto;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        inventory = new Inventory();
        inventory.setInventoryId(1);

        dto = new AvailableInventoryResponseDTO();
        dto.setIsbn("1-111-11111-4");
        dto.setBookTitle("Women are From Venus ORACLE is from Beyond Pluto");
    }

    @Test
    void testGetAvailableInventory_Success() {

        List<Inventory> inventoryList = new ArrayList<>();
        inventoryList.add(inventory);

        when(inventoryRepository.findAvailableInventory()).thenReturn(inventoryList);
        when(converter.convert(inventory)).thenReturn(dto);

        List<AvailableInventoryResponseDTO> result = inventoryService.getAvailableInventory();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("1-111-11111-4", result.get(0).getIsbn());

        verify(inventoryRepository, times(1)).findAvailableInventory();
        verify(converter, times(1)).convert(inventory);
    }

    @Test
    void testGetAvailableInventory_EmptyList() {

        when(inventoryRepository.findAvailableInventory()).thenReturn(new ArrayList<>());

        InventoryNotFoundException exception = assertThrows(
                InventoryNotFoundException.class,
                () -> inventoryService.getAvailableInventory()
        );

        assertEquals("Stock is empty", exception.getMessage());

        verify(inventoryRepository, times(1)).findAvailableInventory();
        verify(converter, never()).convert(any());
    }

    @Test
    void testGetAvailableInventory_Null() {

        when(inventoryRepository.findAvailableInventory()).thenReturn(null);

        InventoryNotFoundException exception = assertThrows(
                InventoryNotFoundException.class,
                () -> inventoryService.getAvailableInventory()
        );

        assertEquals("Stock is empty", exception.getMessage());

        verify(inventoryRepository, times(1)).findAvailableInventory();
    }
}
