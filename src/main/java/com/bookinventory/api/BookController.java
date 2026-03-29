package com.bookinventory.api;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookinventory.dto.AllBookResponseDTO;
import com.bookinventory.dto.converter.AllBookResponseConverter;
import com.bookinventory.model.Book;
import com.bookinventory.service.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {
	BookService bookService;
	
	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AllBookResponseDTO>> getAllBooks() {
		log.info("Requesting Endpoint(/api/books/) to fetch all books");
		
		List<Book> books = bookService.getAllBooks();
		
		List<AllBookResponseDTO> responseBody = books.stream()
				.map(AllBookResponseConverter::convert)
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(responseBody, HttpStatus.OK);
	}
}
