package com.soonyoong.junit;

import com.soonyoong.junit.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    public Book findBookById(Long id) {
        // Some logic to retrieve a book by ID from a data source
        // For simplicity, let's assume it always returns null in this example
        return null;
    }
}
