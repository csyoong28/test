package com.soonyoong.junit;

import com.soonyoong.junit.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
    public void testGetBookById_BookFound() {
        // Arrange
        Long bookId = 1L;
        Book mockBook = new Book(bookId, "Mock Book Title", "Mock Author");

        // Mocking the behavior of the bookService
        Mockito.when(bookService.findBookById(bookId)).thenReturn(mockBook);

        // Act
        ResponseEntity<Book> responseEntity = bookController.getBookById(bookId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBook, responseEntity.getBody());
    }

    @Test
    public void testGetBookById_BookNotFound() {
        // Arrange
        Long bookId = 2L;

        // Mocking the behavior of the bookService
        Mockito.when(bookService.findBookById(bookId)).thenReturn(null);

        // Act
        ResponseEntity<Book> responseEntity = bookController.getBookById(bookId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
}
