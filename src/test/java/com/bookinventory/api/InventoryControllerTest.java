package com.bookinventory.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.dto.InventoryResponseDTO;
import com.bookinventory.exception.ResourceNotFoundException;
import com.bookinventory.service.InventoryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(InventoryController.class)
class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private InventoryService inventoryService;

    private static final Logger log = LoggerFactory.getLogger(InventoryControllerTest.class);

    private AvailableInventoryResponseDTO availableDto;
    private InventoryResponseDTO inventoryDto;

    @BeforeEach
    void setup() {

        availableDto = new AvailableInventoryResponseDTO();
        availableDto.setIsbn("1-111-11111-4");
        availableDto.setInventoryID(1000000);
        availableDto.setBookTitle("Women are From Venus ORACLE is from Beyond Pluto");
        availableDto.setConditionDescription("Bad");
        availableDto.setPrice(new BigDecimal("5.0"));

        inventoryDto = new InventoryResponseDTO();
        inventoryDto.setIsbn("1-111-11111-4");
        inventoryDto.setBookTitle("Women are From Venus ORACLE is from Beyond Pluto");
        inventoryDto.setConditionDescription("Bad");
        inventoryDto.setConditionFullDescription("Not much is left of the book. Parts are not legible, cover may be missing.");
        inventoryDto.setPurchasedStatus(false);
    }

    @Test
    void testGetAvailableInventory_Success() throws Exception {

        log.info("Testing getAvailableInventory() - 200 OK");

        List<AvailableInventoryResponseDTO> list = new ArrayList<>();
        list.add(availableDto);

        when(inventoryService.getAvailableInventory()).thenReturn(list);

        mockMvc.perform(
                        get("/api/inventory/available")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(list.size()))
                .andExpect(jsonPath("$[0].isbn").value("1-111-11111-4"))
                .andExpect(jsonPath("$[0].inventoryID").value(1000000))
                .andExpect(jsonPath("$[0].bookTitle").value("Women are From Venus ORACLE is from Beyond Pluto"))
                .andDo(result ->
                        log.info("Response: " + result.getResponse().getContentAsString())
                );
    }

    @Test
    void testGetInventoryById_Success() throws Exception {

        log.info("Testing getInventoryById() - 200 OK");

        when(inventoryService.getInventoryById(100001))
                .thenReturn(inventoryDto);

        mockMvc.perform(
                        get("/api/inventory/100001")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isbn").value("1-111-11111-4"))
                .andExpect(jsonPath("$.bookTitle").value("Women are From Venus ORACLE is from Beyond Pluto"))
                .andExpect(jsonPath("$.conditionDescription").value("Bad"))
                .andExpect(jsonPath("$.conditionFullDescription").value("Not much is left of the book. Parts are not legible, cover may be missing."))
                .andExpect(jsonPath("$.purchasedStatus").value(false))
                .andDo(result ->
                        log.info("Response: " + result.getResponse().getContentAsString())
                );
    }

    @Test
    void testGetAvailableInventory_NotFound() throws Exception {
        log.info("Testing getAvailableInventory() - Exception case");

        when(inventoryService.getAvailableInventory())
                .thenThrow(new ResourceNotFoundException("Stock is empty"));
        mockMvc.perform(
                    get("/api/inventory/available")
                            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNotFound()).andDo(result ->
                log.info("Error Response: "+ result.getResponse().getContentAsString()));
    }

    @Test
    void testGetInventoryById_NotFound() throws Exception {

        log.info("Testing getInventoryById() - Exception case");

        when(inventoryService.getInventoryById(100001))
                .thenThrow(new ResourceNotFoundException("Inventory is not available with id: " + 100001));

        mockMvc.perform(
                        get("/api/inventory/100001")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound())
                .andDo(result ->
                        log.info("Error Response: " + result.getResponse().getContentAsString())
                );
    }
}
