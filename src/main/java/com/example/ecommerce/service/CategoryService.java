package com.example.ecommerce.service;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    void createCategory(Category category);

    String deleteCategory(long categoryId);

    String updateCategory(long categoryId, Category category);
}
