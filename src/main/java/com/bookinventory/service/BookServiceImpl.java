package com.bookinventory.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookinventory.dto.AllBookOfAuthorResponseDTO;
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
		
		if (books.isEmpty()) {
			String message = "No books were found in the system.";
			log.warn(message);
			throw new ResourceNotFoundException(message);
		}
		
		log.info("Successfully fetched all the books from the book repository");
		return books;
	}

	@Override
	public Book getBookDetailsByIsbn(String bookIsbn) {
		log.info("Fetching book with ISBN %s from the book repository"
				.formatted(bookIsbn));
		
		Optional<Book> optBook = bookRepo.findByIdWithDetails(bookIsbn); 
		
		if (optBook.isEmpty()) {
			String message = "Book with ISBN " + bookIsbn + " not found.";
			log.error(message);
			throw new ResourceNotFoundException(message);
		}
		
		log.info("Succesfully found details of book with ISBN " + bookIsbn);
		return optBook.get();
	}

	@Override
	public List<Book> getAllBooksByCategoryId(Integer catId) {
		log.info("Fetching all books belonging to category ID " + catId + 
				" from book repository");
		
		List<Book> books = bookRepo.findAllByCategoryId(catId);
		
		if (books.isEmpty()) {
			String message = "No books found for category ID: " + catId;
			log.warn(message);
			throw new ResourceNotFoundException(message);
		}
		
		log.info("Successfully fetched all the books belonging to category ID %s from the book repository"
				.formatted(catId));

		return books;
	}

	@Override
	public List<AllBookOfAuthorResponseDTO> getAllBookByAuthorId(Integer authorId) {
		log.info("Fetching all books written by author ID " + authorId + 
				" from book repository");
		
		List<AllBookOfAuthorResponseDTO> books = bookRepo.findAllByAuthorId(authorId);
		
		if (books.isEmpty()) {
			String message = "No book found written by author ID: " + authorId;
			log.warn(message);
			throw new ResourceNotFoundException(message);
		}
		
		log.info("Successfully fetched all the books written by author ID %s from the book repository"
				.formatted(authorId));

		return books;
	}
}
