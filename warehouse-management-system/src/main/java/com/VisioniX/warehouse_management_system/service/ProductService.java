package com.VisioniX.warehouse_management_system.service;
import com.VisioniX.warehouse_management_system.entity.Product;
import com.VisioniX.warehouse_management_system.entity.Retailer;
import com.VisioniX.warehouse_management_system.repository.ConsumerRepository;
import com.VisioniX.warehouse_management_system.repository.ProductRepository;
import com.VisioniX.warehouse_management_system.repository.RetailerRepository;
import com.VisioniX.warehouse_management_system.entity.Consumer;
import com.VisioniX.warehouse_management_system.repository.ConsumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }

    public Product update(Long id,
                          Product product) {
        Product existing = getById(id);
        existing.setName(product.getName());
        existing.setCategory(product.getCategory());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());

        return productRepository.save(existing);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    private final RetailerRepository retailerRepository;

    public Retailer createretailer(Retailer retailer) {
        return retailerRepository.save(retailer);
    }

    public List<Retailer> getAllretailer() {
        return retailerRepository.findAll();
    }

    public Retailer getByIdretailer(Long id) {
        return retailerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Retailer not found"));
    }

    public Retailer updateretailer(Long id,
                           Retailer retailer) {

        Retailer existing = getByIdretailer(id);

        existing.setName(retailer.getName());

        return retailerRepository.save(existing);
    }

    public void deleteRetailer(Long id) {
        retailerRepository.deleteById(id);
    }
    private final ConsumerRepository consumerRepository;

    public Consumer createconsumer(
            Consumer consumer) {

        return consumerRepository.save(consumer);
    }

    public List<Consumer> getAllconsumer() {

        return consumerRepository.findAll();
    }

    public Consumer getByIdconsumer(
            Long id) {

        return consumerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Consumer not found"));
    }

    public Consumer updateconsumer(
            Long id,
            Consumer consumer) {

        Consumer existing =
                getByIdconsumer(id);

        existing.setName(
                consumer.getName());

        return consumerRepository.save(existing);
    }

    public void deleteConsumer(
            Long id) {

        consumerRepository.deleteById(id);
    }
}