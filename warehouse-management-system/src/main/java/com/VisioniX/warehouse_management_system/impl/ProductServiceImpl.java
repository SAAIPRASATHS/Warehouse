package com.VisioniX.warehouse_management_system.impl;

import com.VisioniX.warehouse_management_system.entity.Product;
import com.VisioniX.warehouse_management_system.repository.ProductRepository;
import com.VisioniX.warehouse_management_system.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl
        implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}