package com.ohgiraffers.springdatajpa.product.entity;

import lombok.Getter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "PRODUCT_CODE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productCode;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "REGULAR_PRICE")
    private int regularPrice;
    @Column(name = "DISCOUNT_RATE")
    private int discountRate;

    @Formula("regular_price - (regular_price * discount_rate / 100)")
    private int salePrice;


    @JoinColumn(name = "REF_CATEGORY_CODE")
    @ManyToOne
    private Category category;
    @JoinColumn(name = "REF_BRAND_CODE")
    @ManyToOne
    private Brand brand;

    protected Product() {}

    public Product(int productCode, String productName, int regularPrice, int discountRate, int salePrice, Category category, Brand brand) {
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

    public void setRegularPrice(int productPrice) {
        this.regularPrice = productPrice;
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

    @PrePersist
    @PreUpdate
    private void updateSalePrice() {
        this.salePrice = regularPrice - (regularPrice * discountRate / 100);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
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
