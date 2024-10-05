package kg.attractor.onlinelibrary.controller;

import kg.attractor.onlinelibrary.dto.BookDto;
import kg.attractor.onlinelibrary.dto.UserDto;
import kg.attractor.onlinelibrary.model.Category;
import kg.attractor.onlinelibrary.service.BookService;
import kg.attractor.onlinelibrary.service.CategoryService;
import kg.attractor.onlinelibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin")

public class AdminController {
    private final BookService bookService;
    private final CategoryService categoryService;
    private final UserService userService;

    @GetMapping("addCategory")
    public String category(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/addCategory";
    }

    @PostMapping("addCategory")
    public String addCategory(Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/addCategory";
    }

    @PostMapping("deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin/addCategory";
    }

    @GetMapping("addBook")
    public String addBook(Model model) {
        model.addAttribute("book", new BookDto());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("books", bookService.getAllBooks());
        return "admin/addBook";
    }

    @PostMapping("addBook")
    public String addBook(@ModelAttribute BookDto bookDto) {
        bookService.addBook(bookDto);
        return "redirect:/admin/addBook";
    }

    @PostMapping("deleteBook/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/admin/addBook";
    }

    @GetMapping("add")
    public String addAdmin(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "admin/addAdmin";
    }

    @PostMapping("add")
    public String addAdmin(@ModelAttribute UserDto userDto) {
        userService.createAdmin(userDto);
        return "redirect:/profile";
    }
}
