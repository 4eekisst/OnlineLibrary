package kg.attractor.onlinelibrary.service.impl;

import kg.attractor.onlinelibrary.dto.BookDto;
import kg.attractor.onlinelibrary.enums.BookStatus;
import kg.attractor.onlinelibrary.model.Book;
import kg.attractor.onlinelibrary.model.Category;
import kg.attractor.onlinelibrary.repository.BookRepository;
import kg.attractor.onlinelibrary.repository.CategoryRepository;
import kg.attractor.onlinelibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            log.warn("No books found in the repository.");
        }
        return books;
    }

    @Override
    public List<Book> getBooksByCategory(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isEmpty()) {
            log.error("Category with id {} not found", categoryId);
            throw new RuntimeException("Category not found with id: " + categoryId);
        }

        List<Book> books = bookRepository.findByCategoryId(categoryId);
        if (books.isEmpty()) {
            log.info("No books found for category id {}", categoryId);
        }
        return books;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Книга с ID " + id + " не найдена"));
    }

    @Override
    public void updateBookStatus(Long bookId, BookStatus status) {
        Book book = findById(bookId);
        book.setStatus(status);
        bookRepository.save(book);
    }

    @Override
    public void addBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());

        Category category = categoryRepository.findById(bookDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Категория не найдена"));
        book.setCategory(category);

        MultipartFile imageFile = bookDto.getImage();
        if (imageFile != null && !imageFile.isEmpty()) {
            String fileName = imageFile.getOriginalFilename();
            Path path = Paths.get("src/main/resources/static/images/" + fileName);
            try {
                Files.write(path, imageFile.getBytes());
                book.setImage("images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Ошибка при сохранении изображения: " + e.getMessage());
            }
        }

        book.setStatus(BookStatus.AVAILABLE);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
