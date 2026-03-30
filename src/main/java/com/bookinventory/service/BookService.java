package com.bookinventory.service;

import java.util.List;

import com.bookinventory.dto.AllBookOfAuthorResponseDTO;
import com.bookinventory.model.Book;

public interface BookService {
	List<Book> getAllBooks();
	
	Book getBookDetailsByIsbn(String bookIsbn);
	
	List<Book> getAllBooksByCategoryId(Integer catId);
	
	List<AllBookOfAuthorResponseDTO> getAllBookByAuthorId(Integer authorId);
}
