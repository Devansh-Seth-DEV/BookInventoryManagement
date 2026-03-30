package com.bookinventory.dto.converter;

import com.bookinventory.dto.AvailableInventoryResponseDTO;
import com.bookinventory.model.Inventory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AvailableInventoryResponseConverter {

    public AvailableInventoryResponseDTO convert(Inventory inventory){
        String isbn = null;
        String title = null;
        String description = null;
        BigDecimal price = null;
        if(inventory.getBook() != null) {
            isbn = inventory.getBook().getIsbn();
            title = inventory.getBook().getTitle();
        }
        if (inventory.getBookCondition() != null){
            description = inventory.getBookCondition().getDescription();
            price = inventory.getBookCondition().getPrice();
        }

        AvailableInventoryResponseDTO dto = new AvailableInventoryResponseDTO(isbn,
                                                                              inventory.getInventoryId(),
                                                                              title,
                                                                              description,
                                                                              price
        );

        return dto;
    }
}
