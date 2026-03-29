package com.bookinventory.service;

import java.util.List;

import com.bookinventory.model.Book;

public interface BookService {
	List<Book> getAllBooks();
	
	Book getBookDetails(String bookIsbn);
}
