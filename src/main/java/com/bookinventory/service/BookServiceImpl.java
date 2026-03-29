package com.bookinventory.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookinventory.exception.ResourceNotFoundException;
import com.bookinventory.model.Book;
import com.bookinventory.repository.BookRepository;

@Service
public class BookServiceImpl
	implements BookService
{
	@Autowired
	BookRepository bookRepo;

	private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
	
	@Override
	public List<Book> getAllBooks() {
		log.info("Fetching all the books from the book repository");
		
		List<Book> books = bookRepo.findAllWithDetails();
		
		if (books == null || books.isEmpty()) {
			String message = "No books were found in the system.";
			log.warn(message);
			throw new ResourceNotFoundException(message);
		}
		
		log.info("Successfully fetched all the books from the book repository");
		return books;
	}
}
