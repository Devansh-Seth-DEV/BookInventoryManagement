package com.bookinventory.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.bookinventory.dto.UserCartResponseDTO;
import com.bookinventory.dto.UserPurchaseDTO;
import com.bookinventory.dto.UserResponseDTO;
import com.bookinventory.exception.ResourceNotFoundException;
import com.bookinventory.service.ShoppingCartService;
import com.bookinventory.service.UserService;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @MockitoBean
    private ShoppingCartService shoppingCartService;

    private static final Logger log = LoggerFactory.getLogger(UserControllerTest.class);
    private static final String baseUrl = "/api/users";

    private static UserResponseDTO mockUserResponseDTO;
    private static UserCartResponseDTO mockUserCartResponseDTO;

    @BeforeAll
    static void setup() {
        mockUserResponseDTO = new UserResponseDTO();
        mockUserResponseDTO.setFirstName("Ayush");
        mockUserResponseDTO.setLastName("Tiwari");
        mockUserResponseDTO.setUserName("ayush123");
        mockUserResponseDTO.setPhoneNumber("9876543210");
        mockUserResponseDTO.setRoleName("Customer");

        mockUserCartResponseDTO = new UserCartResponseDTO();
        mockUserCartResponseDTO.setIsbn("1-111-11111-4");
        mockUserCartResponseDTO.setBookTitle("Women are From Venus ORACLE is from Beyond Pluto");
        mockUserCartResponseDTO.setEdition("4");
        mockUserCartResponseDTO.setPublisherName("CovertoCover Publishing");
    }

    @Test
    void testGetUserProfile_Success() throws Exception {
        log.info("Testing getUserProfile(Integer userId) for 200-OK Status");

        Integer userId = 1;

        when(userService.getUserProfile(userId)).thenReturn(mockUserResponseDTO);

        mockMvc.perform(
                get(baseUrl + "/" + userId)
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value(mockUserResponseDTO.getFirstName()))
            .andExpect(jsonPath("$.lastName").value(mockUserResponseDTO.getLastName()))
            .andExpect(jsonPath("$.userName").value(mockUserResponseDTO.getUserName()))
            .andExpect(jsonPath("$.phoneNumber").value(mockUserResponseDTO.getPhoneNumber()))
            .andExpect(jsonPath("$.roleName").value(mockUserResponseDTO.getRoleName()))
            .andDo(result ->
                log.info("Test Result: " + result.getResponse().getContentAsString())
            );
    }

    @Test
    void testGetUserProfile_NotFound() throws Exception {
        log.info("Testing getUserProfile(Integer userId) for 404-Not Found Status");

        Integer userId = 999;
        String message = "User with id: " + userId + " not found";

        when(userService.getUserProfile(userId))
                .thenThrow(new ResourceNotFoundException(message));

        mockMvc.perform(
                get(baseUrl + "/" + userId)
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value(message))
            .andExpect(jsonPath("$.status").value(404))
            .andDo(result ->
                log.error("Test Result: " + result.getResponse().getContentAsString())
            );
    }

    @Test
    void testGetUserCart_Success() throws Exception {
        log.info("Testing getUserCart(Integer userId) for 200-OK Status");

        Integer userId = 1;

        List<UserCartResponseDTO> cartItems = new ArrayList<>();
        cartItems.add(mockUserCartResponseDTO);

        when(shoppingCartService.getUserCart(userId)).thenReturn(cartItems);

        mockMvc.perform(
                get(baseUrl + "/" + userId + "/cart")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(cartItems.size()))
            .andExpect(jsonPath("$[0].isbn").value(mockUserCartResponseDTO.getIsbn()))
            .andExpect(jsonPath("$[0].bookTitle").value(mockUserCartResponseDTO.getBookTitle()))
            .andExpect(jsonPath("$[0].edition").value(mockUserCartResponseDTO.getEdition()))
            .andExpect(jsonPath("$[0].publisherName").value(mockUserCartResponseDTO.getPublisherName()))
            .andDo(result ->
                log.info("Test Result: " + result.getResponse().getContentAsString())
            );
    }

    @Test
    void testGetUserCart_NotFound() throws Exception {
        log.info("Testing getUserCart(Integer userId) for 404-Not Found Status");

        Integer userId = 999;
        String message = "No books found in cart for user id: " + userId;

        when(shoppingCartService.getUserCart(userId))
                .thenThrow(new ResourceNotFoundException(message));

        mockMvc.perform(
                get(baseUrl + "/" + userId + "/cart")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value(message))
            .andExpect(jsonPath("$.status").value(404))
            .andDo(result ->
                log.error("Test Result: " + result.getResponse().getContentAsString())
            );
    }
    
    @Test
    public void testGetUserPurchaseHistory_Success() throws Exception {
        log.info("Testing getUserPurchaseHistory(Integer userId) for 200-OK Status");

        Integer userId = 1000000;

        UserPurchaseDTO dto = new UserPurchaseDTO(
        			Integer.valueOf(1000000),
        			"1-111-11111-4",
        			"Women are From Venus ORACLE is from Beyond Pluto",
        			BigDecimal.valueOf(5.0),
        			"Bad"
        		);

        List<UserPurchaseDTO> purchases = new ArrayList<>();
        purchases.add(dto);

        when(userService.getPurchaseHistoryByUserId(userId))
        .thenReturn(purchases);

        mockMvc.perform(
                get(baseUrl + "/" + userId + "/purchases")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.size()").value(purchases.size()))
            .andExpect(jsonPath("$[0].isbn").value(dto.getIsbn()))
            .andExpect(jsonPath("$[0].bookTitle").value(dto.getBookTitle()))
            .andExpect(jsonPath("$[0].price").value(dto.getPrice()))
            .andDo(result ->
                log.info("Test Result: " + result.getResponse().getContentAsString())
            );
    }
    
    @Test
    void testGetUserPurchaseHistory_NotFound() throws Exception {
        log.info("Testing getUserPurchaseHistory(Integer userId) for 404-Not Found Status");

        Integer userId = 1000001;
        String message = "No purchase history found for user with userID: " + userId;

        when(userService.getPurchaseHistoryByUserId(userId))
                .thenThrow(new ResourceNotFoundException(message));

        mockMvc.perform(
                get(baseUrl + "/" + userId + "/purchases")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value(message))
            .andExpect(jsonPath("$.status").value(404))
            .andDo(result ->
                log.error("Test Result: " + result.getResponse().getContentAsString())
            );
    }
}