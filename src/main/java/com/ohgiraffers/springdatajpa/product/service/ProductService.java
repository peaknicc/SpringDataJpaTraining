package com.ohgiraffers.springdatajpa.product.service;

import com.ohgiraffers.springdatajpa.product.dto.BrandDTO;
import com.ohgiraffers.springdatajpa.product.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.product.dto.ProductDTO;
import com.ohgiraffers.springdatajpa.product.entity.Brand;
import com.ohgiraffers.springdatajpa.product.entity.Category;
import com.ohgiraffers.springdatajpa.product.entity.Product;
import com.ohgiraffers.springdatajpa.product.repository.BrandRepository;
import com.ohgiraffers.springdatajpa.product.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;


    public ProductService(ProductRepository productRepository, ModelMapper modelMapper, CategoryRepository categoryRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    public Page<ProductDTO> findProductList(Pageable pageable, String brandName, String categoryName) {

        if (brandName != null && !brandName.isEmpty()) {

            pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1 ,
                    pageable.getPageSize());

            Page<Product> productList =  productRepository.findProductsByBrand(brandName, pageable);

            return productList.map(product -> modelMapper.map(product, ProductDTO.class));

        } else if (categoryName != null && !categoryName.isEmpty()) {

            pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1 ,
                    pageable.getPageSize());

            Page<Product> productList =  productRepository.findProductsByCategory(categoryName, pageable);

            return productList.map(product -> modelMapper.map(product, ProductDTO.class));


        } else {

            pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1 ,
                    pageable.getPageSize(),
                    Sort.by("productCode").descending());

            Page<Product> productList = productRepository.findAll(pageable);

            return productList.map(product -> modelMapper.map(product, ProductDTO.class));
        }
    }

    public Page<ProductDTO> findByProductPrice(Integer salePrice, Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1 ,
                                  pageable.getPageSize(),
                                  Sort.by("salePrice").descending());

        Page<Product> productList = productRepository.findProductsWithSalePrice(salePrice, pageable);

        return productList.map(product -> modelMapper.map(product, ProductDTO.class));
    }

    public List<CategoryDTO> findAllCategory() {
        List<Category> categoryList = categoryRepository.findAllCategory();

        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    public List<BrandDTO> findAllBrand() {
        List<Brand> brandList = brandRepository.findAllBrand();

        return brandList.stream()
                .map(brand -> modelMapper.map(brand, BrandDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void registNewProduct(ProductDTO newProduct) {
        productRepository.save(modelMapper.map(newProduct, Product.class));
    }

    @Transactional
    public void modifyProduct(ProductDTO modifyProduct) {
        Product foundMenu = productRepository.findById(modifyProduct.getProductCode()).orElseThrow(IllegalArgumentException::new);
        foundMenu.setProductName(modifyProduct.getProductName());
        foundMenu.setRegularPrice(modifyProduct.getRegularPrice());
        foundMenu.setDiscountRate(modifyProduct.getDiscountRate());
    }

    public ProductDTO findProductByCode(int productCode) {
        Product product = productRepository.findById(productCode).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(product, ProductDTO.class);
    }

    public void deleteMenu(Integer productCode) {
        productRepository.deleteById(productCode);
    }

}
