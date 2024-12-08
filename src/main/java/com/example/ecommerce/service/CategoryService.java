package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();
    public void createCategory(Category category);
    public String deleteCategory(long categoryId);

    String updateCategory(long categoryId, Category category);
}
