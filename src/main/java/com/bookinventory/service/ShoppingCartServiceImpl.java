package com.bookinventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookinventory.dto.UserCartResponseDTO;
import com.bookinventory.repository.ShoppingCartRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public List<UserCartResponseDTO> getUserCart(Integer userId) {
        logger.info("Fetching cart for userId: {}", userId);

        List<UserCartResponseDTO> cartItems = shoppingCartRepository.getUserCartByUserId(userId);

        logger.info("Successfully fetched {} cart items for userId: {}", cartItems.size(), userId);

        return cartItems;
    }
}