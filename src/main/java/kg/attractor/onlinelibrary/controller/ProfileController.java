package kg.attractor.onlinelibrary.controller;

import kg.attractor.onlinelibrary.model.User;
import kg.attractor.onlinelibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("")

public class ProfileController {
    private final UserService userService;

    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {

        String readerCardNumber = authentication.getName();
        User user = userService.findByReaderCardNumber(readerCardNumber);
        model.addAttribute("user", user);
        return "profile/profile";
    }
}
