package com.bookinventory.dto.converter;

import com.bookinventory.dto.UserResponseDTO;
import com.bookinventory.model.User;

public class UserResponseConverter {

    public static UserResponseDTO convertToUserResponseDTO(User user) {

        if (user == null) {
            return null;
        }

        UserResponseDTO dto = new UserResponseDTO();

        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setUserName(user.getUserName());
        dto.setPhoneNumber(user.getPhoneNumber());

        // role mapping
        if (user.getPermRole() != null) {
            dto.setRoleName(user.getPermRole().getPermRole());
        }

        return dto;
    }
}