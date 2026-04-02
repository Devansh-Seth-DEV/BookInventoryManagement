package com.bookinventory.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookinventory.dto.UserPurchaseDTO;
import com.bookinventory.dto.UserResponseDTO;
import com.bookinventory.exception.ResourceNotFoundException;
import com.bookinventory.repository.UserRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO getUserProfile(Integer userId) {
    	 logger.info("Fetching user profile for userId: {}", userId);

         UserResponseDTO userDTO = userRepository.getUserProfileById(userId)
                 .orElseThrow(() -> {
                     logger.error("User not found with id: {}", userId);
                     return new ResourceNotFoundException("User with id: "+userId+" not found");
                 });

         logger.info("Successfully fetched user profile for userId: {}", userId);

         return userDTO;
    }

	@Override
	public List<UserPurchaseDTO> getPurchaseHistoryByUserId(Integer userId) {
    	 logger.info("Fetching user purchase history for userId: {}", userId);
    	 List<UserPurchaseDTO> purchases = userRepository.getPurchaseHistoryByUserId(userId);
    	 logger.info("Successfully fetched user purchase history record for userID: " + userId);
    	 return purchases;
	}
}