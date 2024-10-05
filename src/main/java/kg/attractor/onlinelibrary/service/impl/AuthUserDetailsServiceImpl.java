package kg.attractor.onlinelibrary.service.impl;

import kg.attractor.onlinelibrary.model.User;
import kg.attractor.onlinelibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String findByReaderCardNumber) throws UsernameNotFoundException {
        User user = userRepository.findByReaderCardNumber(findByReaderCardNumber)
                .orElseThrow(() -> new UsernameNotFoundException("User with account number " + findByReaderCardNumber + " not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getReaderCardNumber(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                getAuthorities(user)
        );
    }

    public Collection<? extends GrantedAuthority> getAuthorities(User user) {
        return List.of(new SimpleGrantedAuthority(user.getAuthority().getRole()));
    }
}

