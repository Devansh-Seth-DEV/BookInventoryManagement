package com.bookinventory.api;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookinventory.dto.AllBookResponseDTO;
import com.bookinventory.dto.AllBookReviewResponseDTO;
import com.bookinventory.dto.BookResponseDTO;
import com.bookinventory.dto.converter.AllBookResponseConverter;
import com.bookinventory.dto.converter.AllBookReviewResponseConverter;
import com.bookinventory.dto.converter.BookResponseConverter;
import com.bookinventory.model.Book;
import com.bookinventory.model.BookReview;
import com.bookinventory.service.BookService;
import com.bookinventory.service.ReviewerService;


@RestController
@RequestMapping("/api/books")
public class BookController {
	private final BookService bookService;
	
	private final  ReviewerService reviewerService;
	
	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	public BookController(BookService bookService, ReviewerService reviewerService) {
	    this.bookService = bookService;
	    this.reviewerService= reviewerService;
	}
	
	
	
	
	@GetMapping
	public ResponseEntity<List<AllBookResponseDTO>> getAllBooks() {
		log.info("Requesting Endpoint(/api/books/) to fetch all books");
		
		List<Book> books = bookService.getAllBooks();
		
		List<AllBookResponseDTO> responseBody = books.stream()
				.map(AllBookResponseConverter::convert)
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(responseBody, HttpStatus.OK);
	}
	
	@GetMapping("/{isbn}")
	public ResponseEntity<BookResponseDTO> getBookWithDetailsById(
				@PathVariable("isbn") String bookIsbn
			) {
		log.info("Requesting Endpoint(/api/books/%s) to fetch book with ISBN %s"
				.formatted(bookIsbn, bookIsbn));
		
		Book book = bookService.getBookDetailsByIsbn(bookIsbn);
		BookResponseDTO responseBody = BookResponseConverter.convert(book);
		
		return new ResponseEntity<>(responseBody, HttpStatus.OK);
	}
	
	@GetMapping("/{isbn}/reviews")
    public ResponseEntity<List<AllBookReviewResponseDTO>> getBookReviews(@PathVariable String isbn) {
        log.info("Request received for reviews of ISBN: {}", isbn);
        
        List<BookReview> reviews = reviewerService.getReviewsByBookIsbn(isbn);
        
        List<AllBookReviewResponseDTO> dtos = reviews.stream()
                .map(AllBookReviewResponseConverter::convert)
                .collect(Collectors.toList());
                
        return ResponseEntity.ok(dtos);
    }
}
