package kg.attractor.onlinelibrary.controller;

import kg.attractor.onlinelibrary.dto.BookRequestDto;
import kg.attractor.onlinelibrary.model.Book;
import kg.attractor.onlinelibrary.service.BookRequestService;
import kg.attractor.onlinelibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("")

public class BookRequestController {
    private final BookService bookService;
    private final BookRequestService bookRequestService;

    @GetMapping("/requestBook/{bookId}")
    public String request(@PathVariable Long bookId, Model model) {
        Book book = bookService.findById(bookId);
        model.addAttribute("book", book);
        return "book/requestBook";
    }

    @PostMapping("/submitBookRequest")
    public String submit(BookRequestDto requestDto) {
        bookRequestService.saveBookRequest(requestDto);
        return "redirect:/";
    }

    @PostMapping("/returnBook/{bookRequestId}")
    public String returnBook(@PathVariable Long bookRequestId) {
        bookRequestService.returnBook(bookRequestId);
        return "redirect:/profile";
    }
}
