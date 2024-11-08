package com.ducphong.product_service.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter

@NoArgsConstructor
public class ProductResponse {
    private String productId;
    private String productName;
    private String productDesc;
    private Double productPrice;
    private Double productRating;
    private String productImage;
    private String productStatus;
    private String categoryId;
    private Store store;

    public ProductResponse(String productId, String productName, String productDesc, Double productRating, Double productPrice, String productImage, String productStatus, String categoryId, Store store) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productRating = productRating;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productStatus = productStatus;
        this.categoryId = categoryId;
        this.store = store;
    }
}
