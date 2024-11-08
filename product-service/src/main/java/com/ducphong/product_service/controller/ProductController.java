package com.ducphong.product_service.controller;

import com.ducphong.product_service.model.Product;
import com.ducphong.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/api/product/{id}")
    public ResponseEntity<?> fetchProductById(@PathVariable String id) {
        return productService.fetchProductById(id);
    }

    @GetMapping("api/category/{categoryId}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable String categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("/api/products")
    public ResponseEntity<?> fetchProducts() {
        return productService.fetchAllProducts();
    }
}
