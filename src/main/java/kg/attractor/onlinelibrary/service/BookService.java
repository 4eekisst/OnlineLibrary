package kg.attractor.onlinelibrary.service;

import kg.attractor.onlinelibrary.dto.BookDto;
import kg.attractor.onlinelibrary.enums.BookStatus;
import kg.attractor.onlinelibrary.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    List<Book> getBooksByCategory(Long categoryId);
    Book findById(Long id);
    void updateBookStatus(Long bookId, BookStatus status);
    void addBook(BookDto bookDto);
}
