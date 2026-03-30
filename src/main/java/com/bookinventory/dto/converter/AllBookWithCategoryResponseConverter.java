package com.bookinventory.dto.converter;

import com.bookinventory.dto.AllBookWithCategoryResponseDTO;
import com.bookinventory.model.Book;
import com.bookinventory.model.Category;

public class AllBookWithCategoryResponseConverter {
	public static AllBookWithCategoryResponseDTO convert(Book book) {
		String categoryDescription = null;
		
		if (book.getCategory() != null) {
			categoryDescription = book.getCategory().getCatDescription();
		}
		
		AllBookWithCategoryResponseDTO dto = new AllBookWithCategoryResponseDTO(
					book.getIsbn(),
					book.getTitle(),
					book.getEdition(),
					categoryDescription
				);
		
		return dto;
	}
	
	public static Book convert(AllBookWithCategoryResponseDTO dto) {
		Book book = new Book();
		book.setIsbn(dto.getIsbn());
		book.setTitle(dto.getTitle());
		book.setEdition(dto.getEdition());
		
		Category category = new Category();
		category.setCatDescription(dto.getCategoryDescription());
		
		book.setCategory(category);
		
		return book;
	}
}
