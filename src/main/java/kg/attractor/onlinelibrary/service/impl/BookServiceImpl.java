package kg.attractor.onlinelibrary.service.impl;

import kg.attractor.onlinelibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class BookServiceImpl {
    private final BookRepository bookRepository;

}
