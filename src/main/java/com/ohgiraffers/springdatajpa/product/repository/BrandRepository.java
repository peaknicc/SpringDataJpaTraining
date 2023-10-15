package com.ohgiraffers.springdatajpa.product.repository;

import com.ohgiraffers.springdatajpa.product.entity.Brand;
import com.ohgiraffers.springdatajpa.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    @Query(value = "SELECT BRAND_CODE, BRAND_NAME FROM BRAND ORDER BY BRAND_CODE ASC"
            , nativeQuery = true)
    public List<Brand> findAllBrand();
}
