package com.bookinventory.service;

import java.util.List;

import com.bookinventory.dto.UserPurchaseDTO;
import com.bookinventory.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO getUserProfile(Integer userId);
    
    List<UserPurchaseDTO> getPurchaseHistoryByUserId(Integer userId);
}