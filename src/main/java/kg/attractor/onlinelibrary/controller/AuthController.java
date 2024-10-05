package kg.attractor.onlinelibrary.controller;

import kg.attractor.onlinelibrary.dto.UserDto;
import kg.attractor.onlinelibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {
    private final UserService userService;

    @GetMapping("login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "auth/register";
    }

    @PostMapping("register")
    public String register(UserDto userDto, Model model) {
        String readerCardNumber = userService.create(userDto);
        model.addAttribute("readerCardNumber", readerCardNumber);
        return "auth/registrationSuccess";
    }

    @GetMapping("registration_success")
    public String success(Model model) {
        return "auth/registrationSuccess";
    }
}
