package com.ducphong.product_service.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private String storeId;
    private String storeName;
    private String industry;
    private Double storeRating;
    private String storeLogoImage;
    private String storeAddress;
    private String storePhoneNumber;
    private String promotion_Id;

}
