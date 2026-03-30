package com.bookinventory.dto.converter;

import com.bookinventory.dto.BookResponseDTO;
import com.bookinventory.model.Book;
import com.bookinventory.model.Category;
import com.bookinventory.model.Publisher;

public class BookResponseConverter {
	public static BookResponseDTO convert(Book book) {
		BookResponseDTO dto = new BookResponseDTO(
					book.getIsbn(),
					book.getTitle(),
					book.getDescription(),
					book.getEdition(),
					book.getCategory().getCatDescription(),
					book.getPublisher().getName(),
					book.getPublisher().getCity()
				);
		
		return dto;
	}
	
	public static Book convert(BookResponseDTO dto) {
		Book book = new Book();
		book.setIsbn(dto.getIsbn());
		book.setTitle(dto.getTitle());
		book.setDescription(dto.getDescription());
		book.setEdition(dto.getEdition());
		
		book.setCategory(new Category());
		book.getCategory().setCatDescription(dto.getCategoryName());
		
		book.setPublisher(new Publisher());
		book.getPublisher().setName(dto.getPublisherName());
		book.getPublisher().setCity(dto.getPublisherCity());
		
		return book;
	}
}
