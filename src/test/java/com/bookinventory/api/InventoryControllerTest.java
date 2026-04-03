package com.bookinventory.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import com.bookinventory.dto.AvailableInventoryResponseDTO;

import com.bookinventory.dto.LowStockResponseDTO;
import com.bookinventory.exception.ResourceNotFoundException;
import com.bookinventory.service.InventoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(InventoryController.class)
class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private InventoryServiceImpl inventoryService;

    private static final Logger log = LoggerFactory.getLogger(InventoryControllerTest.class);

    private AvailableInventoryResponseDTO mockDto;
    private LowStockResponseDTO lowStockDto;

    /**
     * Prepares fresh Mock DTO instances before each test execution.
     * Ensures an isolated and predictable state for inventory and low-stock data scenarios.
     */
    @BeforeEach
    void setup() {

        mockDto = new AvailableInventoryResponseDTO();
        mockDto.setIsbn("1-111-11111-4");
        mockDto.setBookTitle("Women are From Venus ORACLE is from Beyond Pluto");

        lowStockDto = new LowStockResponseDTO(
                "1-111-11111-4",
                "Women are From Venus ORACLE is from Beyond Pluto",
                3L
        );
    }

    /**
     * Test Case: Retrieve all available inventory units.
     * Validates that the endpoint correctly returns a 200 OK status and maps 
     * the AvailableInventoryResponseDTO list for the storefront.
     */
    @Test
    void testGetAvailableInventory_Success() throws Exception {

        log.info("Testing getAvailableInventory() for 200-OK Status");

        List<AvailableInventoryResponseDTO> list = new ArrayList<>();
        list.add(mockDto);

        when(inventoryService.getAvailableInventory()).thenReturn(list);

        mockMvc.perform(
                        get("/api/inventory/available")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].isbn").value("1-111-11111-4"))
                .andExpect(jsonPath("$[0].bookTitle").value("Women are From Venus ORACLE is from Beyond Pluto"))
                .andDo(result ->
                        log.info("Response: " + result.getResponse().getContentAsString())
                );
    }
    
    /**
     * Test Case: Identify books with low stock levels.
     * Confirms the controller correctly processes and returns a 200 OK status 
     * with the currentStock counts for restocking alerts.
     */
    @Test
    void testGetLowStock_Success() throws Exception {

        log.info("Testing getLowStock() for 200-OK Status");

        List<LowStockResponseDTO> list = new ArrayList<>();
        list.add(lowStockDto);

        when(inventoryService.getLowStock()).thenReturn(list);

        mockMvc.perform(
                        get("/api/inventory/low-stock")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].isbn").value("1-111-11111-4"))
                .andExpect(jsonPath("$[0].bookTitle").value("Women are From Venus ORACLE is from Beyond Pluto"))
                .andExpect(jsonPath("$[0].currentStock").value(3L))
                .andDo(result ->
                        log.info("Response: " + result.getResponse().getContentAsString())
                );
    }

    /**
     * Test Case: Handle scenario where no books fall below the low-stock threshold.
     * Ensures that the ResourceNotFoundException is caught and translated 
     * into a 404 Not Found response by the API.
     */
    @Test
    void testGetLowStock_NotFound() throws Exception {

        log.info("Testing getLowStock() - Exception case");

        when(inventoryService.getLowStock())
                .thenThrow(new ResourceNotFoundException("No Book is less Stock"));

        mockMvc.perform(
                        get("/api/inventory/low-stock")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound())
                .andDo(result ->
                        log.info("Error Response: " + result.getResponse().getContentAsString())
                );
    }
}

