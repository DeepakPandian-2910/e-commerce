package com.example.ecommerce.controller;

import com.example.ecommerce.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    List<Category> categoryList = new ArrayList<>();

    @PostMapping("/api/admin/category")
    public void addCategory (@RequestBody Category category) {
        categoryList.add(category);
    }

    @GetMapping("api/public/categories")
    public  List<Category> getAllCategories() {
        return categoryList;
    }
}
