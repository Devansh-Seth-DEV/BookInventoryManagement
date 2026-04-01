package com.bookinventory.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookinventory.dto.UserCartResponseDTO;
import com.bookinventory.dto.UserPurchaseDTO;
import com.bookinventory.dto.UserResponseDTO;
import com.bookinventory.service.ShoppingCartService;
import com.bookinventory.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    
    @Autowired
    public UserController(UserService userService, ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUserProfile(@PathVariable Integer userId) {
    	logger.info("Fetching user profile for userId: {}", userId);

        UserResponseDTO response = userService.getUserProfile(userId);

        logger.info("Successfully fetched user profile for userId: {}", userId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/cart")
    public ResponseEntity<List<UserCartResponseDTO>> getUserCart(@PathVariable Integer userId) {
        logger.info("API call received for cart of userId: {}", userId);

        List<UserCartResponseDTO> response = shoppingCartService.getUserCart(userId);

        logger.info("API response sent for cart of userId: {}", userId);

        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{userId}/purchases")
    public ResponseEntity<List<UserPurchaseDTO>> getUserPurchaseHistory(
    		@PathVariable Integer userId
    	) {
        logger.info("API call received for purchases of userId: {}", userId);

        userService.getUserProfile(userId);
        List<UserPurchaseDTO> purchases = userService.getPurchaseHistoryByUserId(userId);

        logger.info("API response sent for purchases of userId: {}", userId);

        return ResponseEntity.ok(purchases);
    }
}