package com.ohgiraffers.springdatajpa.product.dto;


public class ProductDTO {

    private int productCode;
    private String productName;
    private int regularPrice;
    private int discountRate;
    private int salePrice;

    private CategoryDTO category;
    private BrandDTO brand;

    public ProductDTO() {
    }

    public ProductDTO(int productCode, String productName, int regularPrice, int discountRate, int salePrice, CategoryDTO category, BrandDTO brand) {
        this.productCode = productCode;
        this.productName = productName;
        this.regularPrice = regularPrice;
        this.discountRate = discountRate;
        this.salePrice = salePrice;
        this.category = category;
        this.brand = brand;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(int regularPrice) {
        this.regularPrice = regularPrice;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productCode=" + productCode +
                ", productName='" + productName + '\'' +
                ", regularPrice=" + regularPrice +
                ", discountRate=" + discountRate +
                ", salePrice=" + salePrice +
                ", category=" + category +
                ", brand=" + brand +
                '}';
    }
}
