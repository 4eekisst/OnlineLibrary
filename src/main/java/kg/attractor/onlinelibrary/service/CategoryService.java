package kg.attractor.onlinelibrary.service;

import kg.attractor.onlinelibrary.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void addCategory(Category category);
    void deleteCategory(Long id);
    Category findById(Long id);
}
