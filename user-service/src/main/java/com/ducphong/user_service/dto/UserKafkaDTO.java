package com.ducphong.user_service.dto;

import org.springframework.data.annotation.Transient;

public class UserKafkaDTO {
    private String id;

    private String email;

    private String storeName;

    private String industry;

    private String storeLogoImage;

    private String storeAddress;

    private String storePhoneNumber;

    public UserKafkaDTO() {}

    public UserKafkaDTO(String email, String storeName, String industry, String storeLogoImage, String storeAddress, String storePhoneNumber, String id) {
        this.email = email;
        this.storeName = storeName;
        this.industry = industry;
        this.storeLogoImage = storeLogoImage;
        this.storeAddress = storeAddress;
        this.storePhoneNumber = storePhoneNumber;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
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
}
