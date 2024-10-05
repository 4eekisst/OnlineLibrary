package kg.attractor.onlinelibrary.controller;

import kg.attractor.onlinelibrary.model.Book;
import kg.attractor.onlinelibrary.model.Category;
import kg.attractor.onlinelibrary.service.CategoryService;
import kg.attractor.onlinelibrary.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("")

public class BookController {
    private final BookServiceImpl bookService;
    private final CategoryService categoryService;

    @GetMapping("/books")
    public String filter(@RequestParam(required = false) Long categoryId, Model model) {
        List<Book> books;
        if (categoryId != null) {
            books = bookService.getBooksByCategory(categoryId);
        } else {
            books = bookService.getAllBooks();
        }
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("books", books);
        model.addAttribute("categories", categories);
        return "main/main";
    }
}
