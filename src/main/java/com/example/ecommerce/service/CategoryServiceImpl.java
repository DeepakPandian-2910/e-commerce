package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        categoryList.remove(category);
        return "Category with categoryId : " + categoryId + " deleted successfully";
    }

    @Override
    public String updateCategory(long categoryId, Category category) {
        Optional<Category> optionalCategory = categoryList.stream()
                .filter(c -> c.getCategoryId() == categoryId)
                .findFirst();

        if (optionalCategory.isPresent()) {
            optionalCategory.get().setCategoryName(category.getCategoryName());
            return "Category with categoryId : " + categoryId + " updated successfully";
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }
}
