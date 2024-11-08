package com.ducphong.product_service.service;

import com.ducphong.product_service.model.Category;
import com.ducphong.product_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<?> createCategory(Category category){
        try{
            return new ResponseEntity<Category>(categoryRepository.save(category), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchCategoryById(String id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            return new ResponseEntity<>(category, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Category Found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchCategories(){
        List<Category> categories = categoryRepository.findAll();
        if(!categories.isEmpty()){
            return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Categories",HttpStatus.NOT_FOUND);
        }
    }
}
