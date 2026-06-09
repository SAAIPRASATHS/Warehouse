package com.VisioniX.warehouse_management_system.controller;

import com.VisioniX.warehouse_management_system.entity.Product;
import com.VisioniX.warehouse_management_system.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product addProduct(
            @RequestBody Product product) {

        return service.saveProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {

        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(
            @PathVariable Long id) {

        return service.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(
            @PathVariable Long id) {

        service.deleteProduct(id);

        return "Product Deleted";
    }
}