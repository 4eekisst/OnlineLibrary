package kg.attractor.onlinelibrary.controller;

import kg.attractor.onlinelibrary.dto.UserProfileDto;
import kg.attractor.onlinelibrary.model.Book;
import kg.attractor.onlinelibrary.model.User;
import kg.attractor.onlinelibrary.service.BookRequestService;
import kg.attractor.onlinelibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("")

public class ProfileController {
    private final UserService userService;
    private final BookRequestService bookRequestService;

    
    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {
        String readerCardNumber = authentication.getName();
        UserProfileDto userProfile = userService.getUserProfile(readerCardNumber);

        model.addAttribute("user", userProfile.getUser());
        model.addAttribute("isAdmin", userProfile.isAdmin());

        if (userProfile.isAdmin()) {
            List<User> allUsers = userService.getAllUsers(readerCardNumber);
            model.addAttribute("allUsers", allUsers);

            Map<String, List<Book>> borrowedBooksMap = new HashMap<>();
            for (User user : allUsers) {
                List<Book> borrowedBooks = bookRequestService.getBorrowedBooksByUser(user.getReaderCardNumber());
                borrowedBooksMap.put(user.getReaderCardNumber(), borrowedBooks);
            }
            model.addAttribute("borrowedBooksMap", borrowedBooksMap);
        } else {
            List<Book> borrowedBooks = bookRequestService.getBorrowedBooksByUser(readerCardNumber);
            model.addAttribute("borrowedBooks", borrowedBooks);
            model.addAttribute("bookRequests", bookRequestService.getBookRequestsByUser(readerCardNumber));
        }

        return "profile/profile";
    }
}
