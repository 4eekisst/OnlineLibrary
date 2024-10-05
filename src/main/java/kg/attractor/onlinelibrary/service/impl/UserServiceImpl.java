package kg.attractor.onlinelibrary.service.impl;

import kg.attractor.onlinelibrary.dto.UserDto;
import kg.attractor.onlinelibrary.model.Authority;
import kg.attractor.onlinelibrary.model.User;
import kg.attractor.onlinelibrary.repository.AuthorityRepository;
import kg.attractor.onlinelibrary.repository.UserRepository;
import kg.attractor.onlinelibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    private String generateReaderCardNumber() {
        return String.format("%06d", new Random().nextInt(1000000));
    }

    @Override
    public User findByReaderCardNumber(String readerCardNumber) {
        return userRepository.findByReaderCardNumber(readerCardNumber).stream()
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User with reader card number " + readerCardNumber + " not found"));
    }

    @Override
    public String create(UserDto userDto) {
        Authority authority = authorityRepository.findByRole("user")
                .orElseThrow(() -> new IllegalArgumentException("Authority not found"));

        User user = User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .patronymic(userDto.getPatronymic())
                .address(userDto.getAddress())
                .passportNumber(userDto.getPassportNumber())
                .readerCardNumber(generateReaderCardNumber())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .enabled(true)
                .authority(authority)
                .build();

        userRepository.save(user);

        return user.getReaderCardNumber();
    }
}
