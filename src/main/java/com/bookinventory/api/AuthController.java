package com.bookinventory.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookinventory.dto.LoginRequestDTO;
import com.bookinventory.dto.UserResponseDTO;
import com.bookinventory.model.User;
import com.bookinventory.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    /**
     * Validates user credentials and initiates an authenticated session.
     * @param request LoginRequestDTO containing the username and password.
     * @return ResponseEntity containing UserResponseDTO or an error message.
     */    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        try {
            User user = userService.login(request.getUsername(), request.getPassword());
            UserResponseDTO dto = userService.getUserProfile(user.getUserId());
            return ResponseEntity.ok(dto);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Persists a new user profile into the system repository.
     * @param user The User entity containing registration data.
     * @return ResponseEntity containing the persisted User object or an error message.
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        try {
            User saved = userService.createUser(user);
            return ResponseEntity.ok(saved);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}