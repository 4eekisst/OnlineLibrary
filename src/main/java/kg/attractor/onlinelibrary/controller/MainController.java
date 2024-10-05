package kg.attractor.onlinelibrary.controller;

import kg.attractor.onlinelibrary.model.Book;
import kg.attractor.onlinelibrary.model.BookRequest;
import kg.attractor.onlinelibrary.model.Category;
import kg.attractor.onlinelibrary.service.BookRequestService;
import kg.attractor.onlinelibrary.service.CategoryService;
import kg.attractor.onlinelibrary.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("")


public class MainController {
    private final BookServiceImpl bookService;
    private final CategoryService categoryService;
    private final BookRequestService bookRequestService;


    @GetMapping()
    public String mainPage(Model model, Authentication authentication) {
        List<Book> books = bookService.getAllBooks();
        List<Category> categories = categoryService.getAllCategories();

        model.addAttribute("books", books);
        model.addAttribute("categories", categories);

        if (authentication != null) {
            String readerCardNumber = authentication.getName();
            List<BookRequest> bookRequests = bookRequestService.getBookRequestsByUser(readerCardNumber);
            model.addAttribute("bookRequests", bookRequests);
        }
        return "main/main";
    }
}
