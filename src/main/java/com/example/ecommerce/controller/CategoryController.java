package com.example.ecommerce.controller;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/api/admin/category")
    public String addCategory (@RequestBody Category category) {
        categoryService.createCategory(category);
        return "Category added successfully";
    }

    @GetMapping("api/public/categories")
    public  List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @DeleteMapping("api/admin/category/{categoryId}")
    public String deleteCategory(@PathVariable long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
}
