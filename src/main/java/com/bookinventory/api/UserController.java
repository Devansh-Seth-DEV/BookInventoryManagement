package com.bookinventory.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookinventory.dto.UserResponseDTO;
import com.bookinventory.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUserProfile(@PathVariable Integer userId) {
    	logger.info("Fetching user profile for userId: {}", userId);

        UserResponseDTO response = userService.getUserProfile(userId);

        logger.info("Successfully fetched user profile for userId: {}", userId);

        return ResponseEntity.ok(response);
    }
}