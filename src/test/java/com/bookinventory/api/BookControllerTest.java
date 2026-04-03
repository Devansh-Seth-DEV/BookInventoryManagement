package com.bookinventory.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.bookinventory.dto.AllBookOfAuthorResponseDTO;
import com.bookinventory.dto.AllBookReviewResponseDTO;
import com.bookinventory.exception.ResourceNotFoundException;
import com.bookinventory.model.Book;
import com.bookinventory.model.BookReview;
import com.bookinventory.model.Category;
import com.bookinventory.model.Publisher;
import com.bookinventory.model.Reviewer;
import com.bookinventory.model.State;
import com.bookinventory.service.BookService;
import com.bookinventory.service.ReviewerService;

@WebMvcTest(BookController.class)
class BookControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private BookService bookService;
	
	@MockitoBean
	private ReviewerService reviewerService;

	private static final Logger log = LoggerFactory.getLogger(BookControllerTest.class);
	private static Book mockBook;
	private final static String baseUrl = "/api/books";

	/**
     * Set up a shared mock Book entity with associated Publisher and Category.
     * Provides a consistent data baseline for all controller test cases.
     */	
	@BeforeAll
	static void setup() {
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

		Category c = new Category();
		c.setCatId(1);
		c.setCatDescription("Romance");

		mockBook.setPublisher(p);
		mockBook.setCategory(c);
	}
	
	/**
     * Test Case: Retrieve all books successfully.
     * Verifies that the endpoint returns a 200 OK status and a JSON array 
     * matching the service layer output.
     */
	@Test
	void testGetAllBooks_Success() throws Exception {
		log.info("Testing getAllBooks() for 200-OK Status");
	
		
		List<Book> books = new ArrayList<>();
		books.add(mockBook);
		
		when(bookService.getAllBooks()).thenReturn(books);
		
		mockMvc.perform(
				get(baseUrl)
				.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()").value(books.size()))
			.andExpect(jsonPath("$[0].isbn").value(mockBook.getIsbn()))
            .andExpect(jsonPath("$[0].edition").value(mockBook.getEdition()))
            .andDo(result -> 
            	log.info("Test Result: " + result.getResponse().getContentAsString())
            );
	}

	/**
     * Test Case: Handle request when no books exist.
     * Validates that the Global Exception Handler converts a ResourceNotFoundException 
     * into a 404 Not Found status with the correct error message.
     */
	@Test
	public void testGetAllBooks_NotFound() throws Exception {
		log.info("Testing getAllBooks() for 404-Not Found Status");
		
		String message = "No books were found in the system.";
	    when(bookService.getAllBooks())
	           .thenThrow(new ResourceNotFoundException(message));

	    mockMvc.perform(
					get(baseUrl)
					.contentType(MediaType.APPLICATION_JSON)
	    		)
	            .andExpect(status().isNotFound())
	            .andExpect(jsonPath("$.message").value(message))
	            .andExpect(jsonPath("$.status").value(404))
	            .andDo(result -> 
	            	log.error("Test Result: " + result.getResponse().getContentAsString())
	            );
	}
	
	/**
     * Test Case: Retrieve a specific book by its ISBN.
     * Ensures the endpoint correctly maps the book entity to a detail-oriented 
     * JSON response with a 200 OK status.
     */
	@Test
	public void testGetBookWithDetailsById_Success() throws Exception {
		log.info("Testing getBookWithDetailsById(String isbn) for 200 OK Status");
		
		when(bookService.getBookDetailsByIsbn(mockBook.getIsbn()))
		.thenReturn(mockBook);
		
		mockMvc.perform(
				get(baseUrl + "/" + mockBook.getIsbn())
				.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.isbn").value(mockBook.getIsbn()))
            .andExpect(jsonPath("$.edition").value(mockBook.getEdition()))
            .andExpect(
            		jsonPath("$.categoryName")
            		.value(mockBook.getCategory().getCatDescription())
            )
            .andDo(result -> 
            	log.info("Test Result: " + result.getResponse().getContentAsString())
            );
	}

	/**
     * Test Case: Handle search for a non-existent ISBN.
     * Confirms that requesting a missing book returns a 404 status and 
     * descriptive error metadata.
     */
	@Test
	public void testGetBookByIdWithDetails_NotFound() throws Exception {
		log.info("Testing getBookWithDetailsById(String isbn) for 404-Not Found Status");
		
		String bookIsbn = "1-000-10000-0";
		String message = "Book with ISBN " + bookIsbn + " was not found.";
		when(bookService.getBookDetailsByIsbn(bookIsbn))
	           .thenThrow(new ResourceNotFoundException(message));

	    mockMvc.perform(
					get(baseUrl + "/" + bookIsbn)
					.contentType(MediaType.APPLICATION_JSON)
	    		)
	            .andExpect(status().isNotFound())
	            .andExpect(jsonPath("$.message").value(message))
	            .andExpect(jsonPath("$.status").value(404))
	            .andDo(result -> 
	            	log.error("Test Result: " + result.getResponse().getContentAsString())
	            );
	}
	
	/**
     * Test Case: Filter books by Category ID.
     * Checks that the path variable is correctly passed to the service 
     * and returns the expected list of books for that genre.
     */
	@Test
	public void testGetAllBooksByCategory_Success() throws Exception {
		log.info("Testing testGetAllBooksByCategory(Integer catId) for 200 OK Status");
		
		List<Book> books = new ArrayList<>();
		books.add(mockBook);
		
		Integer catId = mockBook.getCategory().getCatId();

		when(bookService.getAllBooksByCategoryId(catId))
		.thenReturn(books);
		
		mockMvc.perform(
				get(baseUrl + "/category/" + catId)
				.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].isbn").value(mockBook.getIsbn()))
            .andExpect(jsonPath("$[0].edition").value(mockBook.getEdition()))
            .andExpect(
            		jsonPath("$[0].categoryDescription")
            		.value(mockBook.getCategory().getCatDescription())
            )
            .andDo(result -> 
            	log.info("Test Result: " + result.getResponse().getContentAsString())
            );
	}
	
	/**
     * Test Case: Handle filtering for an empty or invalid Category ID.
     * Verifies 404 status enforcement when the category search yields no results.
     */
	@Test
	public void testGetAllBooksByCategory_NotFound() throws Exception {
		log.info("Testing testGetAllBooksByCategory(Integer catId) for 404-Not Found Status");
		
		Integer catId = 0;
		String message = "No Book found for category ID: " + catId;
		when(bookService.getAllBooksByCategoryId(catId))
		.thenThrow(new ResourceNotFoundException(message));

	    mockMvc.perform(
					get(baseUrl + "/category/" + catId)
					.contentType(MediaType.APPLICATION_JSON)
	    		)
	            .andExpect(status().isNotFound())
	            .andExpect(jsonPath("$.message").value(message))
	            .andExpect(jsonPath("$.status").value(404))
	            .andDo(result -> 
	            	log.error("Test Result: " + result.getResponse().getContentAsString())
	            );
	}
	
	/**
     * Test Case: Retrieve books written by a specific Author.
     * Validates the mapping of the AllBookOfAuthorResponseDTO and ensures 
     * correct JSON serialization of author-specific metadata.
     */
	@Test
	public void testGetAllBookByAuthorId_Success() throws Exception {
		log.info("Testing testGetAllBookByAuthorId(Integer authorId) for 200 OK Status");
		
		String authorFirstName = "Elissa";
		
		AllBookOfAuthorResponseDTO dto = new AllBookOfAuthorResponseDTO(
					mockBook.getIsbn(),
					mockBook.getTitle(),
					authorFirstName, "Weeden",
					"CovertoCover Publishing"
				);

		List<AllBookOfAuthorResponseDTO> books = new ArrayList<>();
		books.add(dto);
		
		Integer authorId = mockBook.getCategory().getCatId();

		when(bookService.getAllBookByAuthorId(authorId))
		.thenReturn(books);
		
		mockMvc.perform(
				get(baseUrl + "/author/" + authorId)
				.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].isbn").value(mockBook.getIsbn()))
            .andExpect(jsonPath("$[0].authorFirstName").value(authorFirstName))
            .andDo(result -> 
            	log.info("Test Result: " + result.getResponse().getContentAsString())
            );
	}

	/**
     * Test Case: Handle search for books by a missing Author ID.
     * Ensures the system responds with a 404 status when no books 
     * are associated with the given author.
     */
	@Test
	public void testGetAllBookByAuthorId_NotFound() throws Exception {
		log.info("Testing testGetAllBookByAuthorId(Integer authorId) for 404-Not Found Status");
		
		Integer authorId = 0;
		String message = "No book found written by author ID: " + authorId;
		when(bookService.getAllBookByAuthorId(authorId))
		.thenThrow(new ResourceNotFoundException(message));

	    mockMvc.perform(
					get(baseUrl + "/author/" + authorId)
					.contentType(MediaType.APPLICATION_JSON)
	    		)
	            .andExpect(status().isNotFound())
	            .andExpect(jsonPath("$.message").value(message))
	            .andExpect(jsonPath("$.status").value(404))
	            .andDo(result -> 
	            	log.error("Test Result: " + result.getResponse().getContentAsString())
	            );
	}

	/**
     * Test Case: Retrieve all reviews for a specific book title.
     * Verifies the integration between the controller and ReviewerService, 
     * ensuring review comments and ratings are returned in the response body.
     */
	@Test
	public void testGetBookReviews_Success() throws Exception {
		log.info("Testing getBookReviews(String isbn) for 200 OK Status");
		
		String authorFirstName = "Elissa";
		
		Reviewer reviewer = new Reviewer(null, "Phelps", "Detroit News");
		
		BookReview bookReview = new BookReview(
					mockBook,
					reviewer,
					10,
					"Hold on to your hats, gang! If you think a cookbook or the yellow pages is exciting reading, you gotta read Professor Spada's remarkable treatise on enriching you personal relationships through your knowledge of ORACLE 8.1.6."
				);

		List<BookReview> reviews = new ArrayList<>();
		reviews.add(bookReview);
		
		Integer authorId = mockBook.getCategory().getCatId();

		when(reviewerService.getReviewsByBookIsbn(mockBook.getIsbn()))
		.thenReturn(reviews);
		
		mockMvc.perform(
				get(baseUrl + "/" + mockBook.getIsbn() +"/reviews")
				.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].isbn").value(mockBook.getIsbn()))
            .andExpect(jsonPath("$[0].reviewerName").value(reviewer.getName()))
            .andExpect(jsonPath("$[0].rating").value(bookReview.getRating()))
            .andDo(result -> 
            	log.info("Test Result: " + result.getResponse().getContentAsString())
            );
	}

	/**
     * Test Case: Handle request for reviews on a book that has none.
     * Confirms a 404 response when the review sub-resource is empty for a given ISBN.
     */
	@Test
	public void testGetBookReviews_NotFound() throws Exception {
		log.info("Testing getBookReviews(String isbn) for 404-Not Found Status");
		
		String isbn = "1-000-10000-1";
		String message = "No one reviewed the book with ISBN " + isbn + " yet!";

		when(reviewerService.getReviewsByBookIsbn(isbn))
		.thenThrow(new ResourceNotFoundException(message));

	    mockMvc.perform(
				get(baseUrl + "/" + isbn +"/reviews")
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
