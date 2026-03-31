package com.bookinventory.dto.converter;

import com.bookinventory.dto.InventoryResponseDTO;
import com.bookinventory.model.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryResponseConverter {
    public static InventoryResponseDTO convert(Inventory inventory) {
        String Isbn = null;
        String title = null;
        String description = null;
        String fullDescription = null;
        Boolean purchased = null;
        if(inventory.getBook() != null){
            Isbn = inventory.getBook().getIsbn();
            title = inventory.getBook().getTitle();
        }
        if(inventory.getBookCondition() != null){
            description = inventory.getBookCondition().getDescription();
            fullDescription = inventory.getBookCondition().getFullDescription();
        }
        purchased = inventory.getPurchased();
        return new InventoryResponseDTO(Isbn,
                                        title,
                                        description,
                                        fullDescription,
                                        purchased
        );
    }
}
