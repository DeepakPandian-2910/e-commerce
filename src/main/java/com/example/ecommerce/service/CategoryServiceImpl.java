package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    List<Category> categoryList = new ArrayList<>();
    long idGenerator = 1;

    @Override
    public List<Category> getAllCategories() {
        return categoryList;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(idGenerator++);
        categoryList.add(category);
    }

    @Override
    public String deleteCategory(long categoryId) {
        Category category = categoryList.stream()
                .filter(c -> c.getCategoryId() == categoryId)
                .findFirst().orElse(null);

        if (category == null) {
            return "Category with categoryId : " + categoryId + " not found";
        }
        categoryList.remove(category);
        return "Category with categoryId : " + categoryId + " deleted successfully";
    }
}
