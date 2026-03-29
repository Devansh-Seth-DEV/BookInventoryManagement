package com.bookinventory.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.bookinventory.exception.ResourceNotFoundException;
import com.bookinventory.model.Book;
import com.bookinventory.model.Publisher;
import com.bookinventory.model.State;
import com.bookinventory.service.BookService;

@WebMvcTest(BookController.class)
class BookControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private BookService bookService;

	private static final Logger log = LoggerFactory.getLogger(BookControllerTest.class);
	private Book mockBook;
	
	@BeforeEach
	void setup() {
		mockBook = new Book();
		mockBook.setIsbn("1-111-11111-4");
		mockBook.setTitle("Women are From Venus ORACLE is from Beyond Pluto");
		mockBook.setDescription("New York Times Best Seller 27 weeks");
		mockBook.setEdition("4");
		
		Publisher p = new Publisher();
		p.setPublisherId(1);
		p.setName("CovertoCover Publishing");
		p.setCity("Rochester");
		p.setState(new State("NY", "New York".toUpperCase()));

		mockBook.setPublisher(p);
	}
	
	@Test
	void testGetAllBooks_Success() throws Exception {
		log.info("Testing getAllBooks() for 200-OK Status");
	
		
		List<Book> books = new ArrayList<>();
		books.add(mockBook);
		
		when(bookService.getAllBooks()).thenReturn(books);
		
		mockMvc.perform(
				get("/api/books/")
				.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()").value(1))
			.andExpect(jsonPath("$[0].isbn").value("1-111-11111-4"))
            .andExpect(jsonPath("$[0].edition").value("4"))
            .andDo(result -> 
            	log.info("Test Result: " + result.getResponse().getContentAsString())
            );
	}

	@Test
	public void testGetAllBooks_NotFound() throws Exception {
		log.info("Testing getAllBooks() for 404-Not Found Status");
		
		String message = "No books were found in the system.";
	    when(bookService.getAllBooks())
	           .thenThrow(new ResourceNotFoundException(message));

	    mockMvc.perform(
					get("/api/books/")
					.contentType(MediaType.APPLICATION_JSON)
	    		)
	            .andExpect(status().isNotFound())
	            .andExpect(jsonPath("$.message").value(message))
	            .andExpect(jsonPath("$.status").value(404))
	            .andDo(result -> 
	            	log.error("Test Result: " + result.getResponse().getContentAsString())
	            );
	}
}
