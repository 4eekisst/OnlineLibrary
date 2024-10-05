package kg.attractor.onlinelibrary.service.impl;

import kg.attractor.onlinelibrary.model.User;
import kg.attractor.onlinelibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class AuthUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String readerCardNumber) throws UsernameNotFoundException {
        User user = userRepository.findByReaderCardNumber(readerCardNumber).stream()
                .findFirst().orElseThrow();
        return new org.springframework.security.core.userdetails.User(
                user.getReaderCardNumber(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                getAuthorities(readerCardNumber)
        );
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String readerCardNumber) {
        User user = userRepository.findByReaderCardNumber(readerCardNumber).stream().findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User with reader card number " + readerCardNumber + " not found"));
        return List.of(new SimpleGrantedAuthority(user.getAuthority().getRole()));
    }
}

