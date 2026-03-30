package com.bookinventory.service;

import java.util.List;

import com.bookinventory.dto.UserCartResponseDTO;

public interface ShoppingCartService {

    List<UserCartResponseDTO> getUserCart(Integer userId);
}