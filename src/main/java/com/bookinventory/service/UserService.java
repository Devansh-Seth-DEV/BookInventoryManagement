package com.bookinventory.service;

import com.bookinventory.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO getUserProfile(Integer userId);
}