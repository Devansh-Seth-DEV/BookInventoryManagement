package com.bookinventory.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import com.bookinventory.dto.AvailableInventoryResponseDTO;

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

    @BeforeEach
    void setup() {

        mockDto = new AvailableInventoryResponseDTO();
        mockDto.setIsbn("1-111-11111-4");
        mockDto.setBookTitle("Women are From Venus ORACLE is from Beyond Pluto");
    }

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

    @Test
    void testGetAvailableInventory_EmptyList() throws Exception {

        log.info("Testing getAvailableInventory() for Empty List");

        when(inventoryService.getAvailableInventory()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/api/inventory/available"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }

}
