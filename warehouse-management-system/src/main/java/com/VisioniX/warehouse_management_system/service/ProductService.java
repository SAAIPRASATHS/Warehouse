package com.VisioniX.warehouse_management_system.service;

import com.VisioniX.warehouse_management_system.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProduct(Long id);
}