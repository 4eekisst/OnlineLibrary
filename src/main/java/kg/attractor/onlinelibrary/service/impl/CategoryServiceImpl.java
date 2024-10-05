package kg.attractor.onlinelibrary.service.impl;

import kg.attractor.onlinelibrary.model.Category;
import kg.attractor.onlinelibrary.repository.CategoryRepository;
import kg.attractor.onlinelibrary.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}

