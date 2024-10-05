package kg.attractor.onlinelibrary.service;

import kg.attractor.onlinelibrary.dto.BookRequestDto;
import kg.attractor.onlinelibrary.model.Book;
import kg.attractor.onlinelibrary.model.BookRequest;

import java.util.List;

public interface BookRequestService {
    void saveBookRequest(BookRequestDto requestDto);
    void returnBook(Long bookRequestId);
    List<BookRequest> getBookRequestsByUser(String readerCardNumber);
    List<Book> getBorrowedBooksByUser(String readerCardNumber);
}
