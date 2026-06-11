package com.VisioniX.warehouse_management_system.controller;

import com.VisioniX.warehouse_management_system.entity.Product;
import com.VisioniX.warehouse_management_system.entity.Retailer;
import com.VisioniX.warehouse_management_system.entity.Consumer;
import com.VisioniX.warehouse_management_system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product create(
            @RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(
            @PathVariable Long id) {

        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public Product update(
            @PathVariable Long id,
            @RequestBody Product product) {

        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id) {

        productService.delete(id);

        return "Deleted Successfully";
    }


    @PostMapping("/retailer")
    public Retailer createretailer(
            @RequestBody Retailer retailer) {

        return productService.createretailer(retailer);
    }

    @GetMapping("/retailer")
    public List<Retailer> getAllretailer() {

        return productService.getAllretailer();
    }

    @GetMapping("/retailer/{id}")
    public Retailer getByIdretailer(
            @PathVariable Long id) {

        return productService.getByIdretailer(id);
    }

    @PutMapping("/retailer/{id}")
    public Retailer updateretailer(
            @PathVariable Long id,
            @RequestBody Retailer retailer) {

        return productService.updateretailer(id, retailer);
    }

    @DeleteMapping("/retailer/{id}")
    public String deleteRetailer(
            @PathVariable Long id) {

        productService.deleteRetailer(id);

        return "Deleted Successfully";
    }

    @PostMapping("/consumer")
    public Consumer createconsumer(
            @RequestBody Consumer consumer) {

        return productService.createconsumer(consumer);
    }

    @GetMapping("/consumer")
    public List<Consumer> getAllconsumer() {

        return productService.getAllconsumer();
    }

    @GetMapping("/consumer/{id}")
    public Consumer getByIdconsumer(
            @PathVariable Long id) {

        return productService.getByIdconsumer(id);
    }

    @PutMapping("/consumer/{id}")
    public Consumer updateconsumer(
            @PathVariable Long id,
            @RequestBody Consumer consumer) {

        return productService.updateconsumer(id, consumer);
    }

    @DeleteMapping("/consumer/{id}")
    public String deleteConsumer(
            @PathVariable Long id) {

        productService.deleteConsumer(id);

        return "Deleted Successfully";
    }

}