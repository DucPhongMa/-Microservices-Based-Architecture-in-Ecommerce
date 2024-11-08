package com.ducphong.store_service.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "stores")
public class Store {
    @Id
    private String storeId;
    private String storeName;
    private String industry;
    private Double storeRating;
    private String storeLogoImage;
    private String storeAddress;
    private String storePhoneNumber;
    private List<String> ownerIds;
    private String promotion_Id;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Double getStoreRating() {
        return storeRating;
    }

    public void setStoreRating(Double storeRating) {
        this.storeRating = storeRating;
    }

    public String getStoreLogoImage() {
        return storeLogoImage;
    }

    public void setStoreLogoImage(String storeLogoImage) {
        this.storeLogoImage = storeLogoImage;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhoneNumber() {
        return storePhoneNumber;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    public List<String> getOwnerId() {
        return ownerIds;
    }

    public void setOwnerId(List<String> ownerId) {
        this.ownerIds = ownerId;
    }

    public String getPromotion_Id() {
        return promotion_Id;
    }

    public void setPromotion_Id(String promotion_Id) {
        this.promotion_Id = promotion_Id;
    }
}
