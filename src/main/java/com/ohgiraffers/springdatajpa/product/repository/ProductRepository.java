package com.ohgiraffers.springdatajpa.product.repository;

import com.ohgiraffers.springdatajpa.product.dto.ProductDTO;
import com.ohgiraffers.springdatajpa.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.salePrice <= :salePrice")
    Page<Product> findProductsWithSalePrice(@Param("salePrice") Integer salePrice, Pageable pageable);

    @Query(value = "SELECT p.PRODUCT_CODE, p.PRODUCT_NAME, p.REGULAR_PRICE, p.DISCOUNT_RATE, " +
            "p.REF_CATEGORY_CODE, p.REF_BRAND_CODE, p.REGULAR_PRICE - (p.REGULAR_PRICE * p.DISCOUNT_RATE / 100) AS salePrice " +
            "FROM PRODUCT p " +
            "JOIN BRAND b ON p.REF_BRAND_CODE = b.BRAND_CODE " +
            "WHERE b.BRAND_NAME = :brandName " +
            "ORDER BY p.PRODUCT_CODE DESC ", nativeQuery = true)
    Page<Product> findProductsByBrand(String brandName, Pageable pageable);

    @Query(value = "SELECT p.PRODUCT_CODE, p.PRODUCT_NAME, p.REGULAR_PRICE, p.DISCOUNT_RATE, " +
            "p.REF_CATEGORY_CODE, p.REF_BRAND_CODE, p.REGULAR_PRICE - (p.REGULAR_PRICE * p.DISCOUNT_RATE / 100) AS salePrice " +
            "FROM PRODUCT p " +
            "JOIN CATEGORY c ON p.REF_CATEGORY_CODE = c.CATEGORY_CODE " +
            "WHERE c.CATEGORY_NAME = :categoryName " +
            "ORDER BY p.PRODUCT_CODE DESC ", nativeQuery = true)
    Page<Product> findProductsByCategory(String categoryName, Pageable pageable);
}
