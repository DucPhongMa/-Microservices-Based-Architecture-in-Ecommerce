package com.ducphong.product_service.controller;

import com.ducphong.product_service.model.Category;
import com.ducphong.product_service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/api/category")
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/api/category/{id}")
    public ResponseEntity<?> fetchCategoryById(@PathVariable String id) {
        return categoryService.fetchCategoryById(id);
    }


    @GetMapping("/api/categories")
    public ResponseEntity<?> fetchCategories() {
        return categoryService.fetchCategories();
    }
}
