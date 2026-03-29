package com.bookinventory.dto;

import com.bookinventory.model.Inventory;
import org.springframework.stereotype.Component;

@Component
public class AvailableInventoryResponseConverter {

    public AvailableInventoryResponseDTO convert(Inventory inventory){

        AvailableInventoryResponseDTO dto = new AvailableInventoryResponseDTO(
                inventory.getBook().getIsbn(),
                inventory.getBook().getTitle(),
                inventory.getBookCondition().getDescription(),
                inventory.getBookCondition().getPrice()
        );

        return dto;
    }
}
