package com.bookinventory.dto.converter;

import com.bookinventory.dto.AllBookResponseDTO;
import com.bookinventory.model.Book;
import com.bookinventory.model.Publisher;

public class AllBookResponseConverter {
	public static AllBookResponseDTO convert(Book book) {
		String publisherName = null;
		if (book.getPublisher() != null) {
			publisherName = book.getPublisher().getName();
		}
		
		AllBookResponseDTO dto = new AllBookResponseDTO(
					book.getIsbn(),
					book.getTitle(),
					book.getDescription(),
					book.getEdition(),
					publisherName
				);
		return dto;
	}
	
	public static Book convert(AllBookResponseDTO dto) {
		Book book = new Book();
		book.setIsbn(dto.getIsbn());
		book.setTitle(dto.getTitle());
		book.setDescription(dto.getDescription());
		book.setEdition(dto.getEdition());
		
		Publisher publisher = new Publisher();
		publisher.setName(dto.getPublisherName());
		book.setPublisher(publisher);
		
		return book;
	}
}
