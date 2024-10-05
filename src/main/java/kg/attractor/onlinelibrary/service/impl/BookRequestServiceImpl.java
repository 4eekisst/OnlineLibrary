package kg.attractor.onlinelibrary.service.impl;

import kg.attractor.onlinelibrary.dto.BookRequestDto;
import kg.attractor.onlinelibrary.enums.BookStatus;
import kg.attractor.onlinelibrary.model.Book;
import kg.attractor.onlinelibrary.model.BookRequest;
import kg.attractor.onlinelibrary.model.User;
import kg.attractor.onlinelibrary.repository.BookRequestRepository;
import kg.attractor.onlinelibrary.service.BookRequestService;
import kg.attractor.onlinelibrary.service.BookService;
import kg.attractor.onlinelibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor

public class BookRequestServiceImpl implements BookRequestService {
    private final BookRequestRepository bookRequestRepository;
    private final UserService userService;
    private final BookService bookService;

    @Override
    public void saveBookRequest(BookRequestDto requestDto) {
        BookRequest bookRequest = new BookRequest();
        Book book = bookService.findById(requestDto.getBookId());

        User user = userService.findByReaderCardNumber(requestDto.getReaderTicket());
        bookRequest.setUser(user);
        bookRequest.setBook(book);

        LocalDate returnDate = requestDto.getReturnDate();
        bookRequest.setReturnDate(returnDate);

        bookRequest.setBookStatus(BookStatus.EXPECTED);

        book.setStatus(BookStatus.EXPECTED);
        book.setExpectedDate(returnDate);

        bookService.updateBookStatus(book.getId(), BookStatus.EXPECTED);

        bookRequestRepository.save(bookRequest);
        log.info("Запрос книги успешно сохранен для книги с ID {}", requestDto.getBookId());
    }

    @Override
    public void returnBook(Long bookRequestId) {
        BookRequest bookRequest = bookRequestRepository.findById(bookRequestId)
                .orElseThrow(() -> new RuntimeException("Запрос книги не найден"));

        Book book = bookRequest.getBook();
        book.setStatus(BookStatus.AVAILABLE);
        bookService.updateBookStatus(book.getId(), BookStatus.AVAILABLE);

        bookRequestRepository.delete(bookRequest);
        log.info("Книга успешно возвращена: {}", book.getTitle());
    }

    @Override
    public List<BookRequest> getBookRequestsByUser(String readerCardNumber) {
        User user = userService.findByReaderCardNumber(readerCardNumber);
        return bookRequestRepository.findByUser(user);
    }

    @Override
    public List<Book> getBorrowedBooksByUser(String readerCardNumber) {
        List<BookRequest> bookRequests = bookRequestRepository.findByUser_ReaderCardNumber(readerCardNumber);
        return bookRequests.stream()
                .map(BookRequest::getBook)
                .collect(Collectors.toList());
    }
}
