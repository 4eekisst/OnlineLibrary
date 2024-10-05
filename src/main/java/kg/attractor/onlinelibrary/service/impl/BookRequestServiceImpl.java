package kg.attractor.onlinelibrary.service.impl;

import kg.attractor.onlinelibrary.service.BookRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class BookRequestServiceImpl implements BookRequestService {
    private final BookRequestService bookRequestService;
}
