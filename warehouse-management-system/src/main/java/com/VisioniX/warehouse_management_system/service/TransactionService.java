package com.VisioniX.warehouse_management_system.service;

import com.VisioniX.warehouse_management_system.entity.Product;
import com.VisioniX.warehouse_management_system.entity.Transaction;
import com.VisioniX.warehouse_management_system.repository.ProductRepository;
import com.VisioniX.warehouse_management_system.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;

    public Transaction createTransaction(Transaction transaction) {
        Product product = productRepository.findById(transaction.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if ("OUT".equalsIgnoreCase(transaction.getTransactionType())) {
            if (product.getQuantity() < transaction.getQuantity()) {
                throw new RuntimeException("Insufficient product quantity");
            }
            product.setQuantity(product.getQuantity() - transaction.getQuantity());
        } else if ("IN".equalsIgnoreCase(transaction.getTransactionType())) {
            product.setQuantity(product.getQuantity() + transaction.getQuantity());
        } else {
            throw new RuntimeException("Invalid transaction type. Must be IN or OUT.");
        }

        productRepository.save(product);
        transaction.setTransactionDate(LocalDateTime.now());
        
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}