package com.ohgiraffers.springdatajpa.product.dto;

public class BrandDTO {

    private int brandCode;
    private String brandName;

    public BrandDTO() {
    }

    public BrandDTO(int brandCode, String brandName) {
        this.brandCode = brandCode;
        this.brandName = brandName;
    }

    public int getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(int brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "BrandDTO{" +
                "brandCode=" + brandCode +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
