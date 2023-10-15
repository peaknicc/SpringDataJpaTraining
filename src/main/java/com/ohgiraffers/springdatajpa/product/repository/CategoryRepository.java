package com.ohgiraffers.springdatajpa.product.repository;

import com.ohgiraffers.springdatajpa.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "SELECT CATEGORY_CODE, CATEGORY_NAME FROM CATEGORY ORDER BY CATEGORY_CODE ASC"
            , nativeQuery = true)
    public List<Category> findAllCategory();
}
