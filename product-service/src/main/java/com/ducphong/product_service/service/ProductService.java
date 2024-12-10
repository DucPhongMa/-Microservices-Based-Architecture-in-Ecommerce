package com.ducphong.product_service.service;

import com.ducphong.product_service.model.Category;
import com.ducphong.product_service.model.Product;
import com.ducphong.product_service.repository.CategoryRepository;
import com.ducphong.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RestTemplate restTemplate;

    public boolean isStoreValid(String storeId) {
        try {
            Store store = restTemplate.getForObject("http://localhost:8082/api/store/" + storeId, Store.class);
            return store != null;
        } catch (Exception e) {
            return false;
        }
    }

    public ResponseEntity<?> addProduct(Product product){
        try{

            // Validate the storeId before proceeding
            if (!isStoreValid(product.getProductStoreId())) {
                return new ResponseEntity<>("Store ID " + product.getProductStoreId() + " not found", HttpStatus.NOT_FOUND);
            }

            Optional<Category> category = categoryRepository.findById(product.getCategoryId());

            if(category.isPresent())
                return new ResponseEntity<Product>(productRepository.save(product), HttpStatus.OK);
            else
                throw new RuntimeException("Category ID " + product.getCategoryId() + " not found");
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchProductById(String id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){

            // Validate the storeId before proceeding
            if (!isStoreValid(product.get().getProductStoreId())) {
                return new ResponseEntity<>("Store ID " + product.get().getProductStoreId() + " not found", HttpStatus.NOT_FOUND);
            }

            Store store = restTemplate.getForObject("http://localhost:8082/api/store/" + product.get().getProductStoreId(), Store.class);
            ProductResponse productResponse = new ProductResponse(
                    product.get().getProductId(),
                    product.get().getProductName(),
                    product.get().getProductDesc(),
                    product.get().getProductPrice(),
                    product.get().getProductRating(),
                    product.get().getProductImage(),
                    product.get().getProductStatus(),
                    product.get().getCategoryId(),
                    store
            );
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Product Found",HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<?> getProductsByCategory(String productCategoryId){
        List<Product> products = productRepository.findByCategoryId(productCategoryId);
        if(!products.isEmpty()){
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Products By Categories",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Page<Product>> fetchAllProducts(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> products = productRepository.findAll(pageable);
        return new ResponseEntity<Page<Product>>(products, HttpStatus.OK);
    }
}
