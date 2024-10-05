package kg.attractor.onlinelibrary.service;

import kg.attractor.onlinelibrary.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    List<Book> getBooksByCategory(Long categoryId);
}
