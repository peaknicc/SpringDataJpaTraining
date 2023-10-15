package com.ohgiraffers.springdatajpa.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRAND")
public class Brand {

    @Id
    @Column(name = "BRAND_CODE")
    private int brandCode;
    @Column(name = "BRAND_NAME")
    private String brandName;

    protected Brand() {}

    public Brand(int brandCode, String brandName) {
        this.brandCode = brandCode;
        this.brandName = brandName;
    }

    public int getBrandCode() {
        return brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandCode(int brandCode) {
        this.brandCode = brandCode;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandCode=" + brandCode +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
