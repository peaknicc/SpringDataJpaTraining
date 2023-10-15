package com.ohgiraffers.springdatajpa.product.controller;

import com.ohgiraffers.springdatajpa.common.Pagenation;
import com.ohgiraffers.springdatajpa.common.PagingButton;
import com.ohgiraffers.springdatajpa.product.dto.ProductDTO;
import com.ohgiraffers.springdatajpa.product.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.product.dto.BrandDTO;
import com.ohgiraffers.springdatajpa.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String findProductList(Model model, @PageableDefault Pageable pageable,
                                  @RequestParam(name = "brandName", required = false) String brandName,
                                  @RequestParam(name = "categoryName", required = false) String categoryName) {

        Page<ProductDTO> productList = productService.findProductList(pageable, brandName, categoryName);

        PagingButton paging = Pagenation.getPagingButtonInfo(productList);

        model.addAttribute("productList", productList);
        model.addAttribute("brandName", brandName);
        model.addAttribute("categoryName", categoryName);
        model.addAttribute("paging", paging);

        return "product/list";
    }

    @GetMapping("/querymethod")
    public void queryMethodPage() {}

    @GetMapping("/search")
    public String findByMenuPrice(@RequestParam Integer salePrice, Model model, @PageableDefault Pageable pageable) {
        Page<ProductDTO> productList = productService.findByProductPrice(salePrice, pageable);

        PagingButton paging = Pagenation.getPagingButtonInfo(productList);

        model.addAttribute("productList", productList);
        model.addAttribute("paging", paging);
        model.addAttribute("salePrice", salePrice);

        return "product/searchResult";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @GetMapping(value = "/category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        return productService.findAllCategory();
    }

    @GetMapping(value = "/brand", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<BrandDTO> findBrandList() {
        return productService.findAllBrand();
    }

    @PostMapping("/regist")
    public String registNewMenu(ProductDTO productDTO) {
        System.out.println("productDTO : "+ productDTO);
        productService.registNewProduct(productDTO);
        return "redirect:/product/list";
    }

    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyProduct(ProductDTO modifyProduct) {
        System.out.println("modifyProduct : "+ modifyProduct);
        productService.modifyProduct(modifyProduct);
        return "redirect:/product/" + modifyProduct.getProductCode();
    }

    @GetMapping("/{productCode}")
    public String findProductByCode(@PathVariable int productCode, Model model) {
        ProductDTO product = productService.findProductByCode(productCode);

        model.addAttribute("product", product);

        return "product/detail";
    }

    @GetMapping("/delete")
    public void deletePage() {}

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Integer productCode) {
        productService.deleteMenu(productCode);

        return "redirect:/product/list";
    }

}
