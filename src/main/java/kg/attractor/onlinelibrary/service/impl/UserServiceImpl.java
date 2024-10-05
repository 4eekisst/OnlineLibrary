package kg.attractor.onlinelibrary.service.impl;

import kg.attractor.onlinelibrary.repository.AuthorityRepository;
import kg.attractor.onlinelibrary.repository.UserRepository;
import kg.attractor.onlinelibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
}
