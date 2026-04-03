package com.bookinventory.service;

import java.util.List;

import com.bookinventory.dto.UserPurchaseDTO;
import com.bookinventory.dto.UserResponseDTO;
import com.bookinventory.model.User;

public interface UserService {
    UserResponseDTO getUserProfile(Integer userId);
    
    List<UserPurchaseDTO> getPurchaseHistoryByUserId(Integer userId);
    User login(String username, String password);
    User createUser(User user);
}