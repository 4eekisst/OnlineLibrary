package kg.attractor.onlinelibrary.service.impl;

import kg.attractor.onlinelibrary.repository.CategoryRepository;
import kg.attractor.onlinelibrary.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
}
