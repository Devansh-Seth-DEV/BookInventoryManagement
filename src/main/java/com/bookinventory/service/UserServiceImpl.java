package com.bookinventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookinventory.dto.UserResponseDTO;
import com.bookinventory.exception.ResourceNotFoundException;
import com.bookinventory.repository.UserRepository;
import com.bookinventory.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO getUserProfile(Integer userId) {
        return userRepository.getUserProfileById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }
}