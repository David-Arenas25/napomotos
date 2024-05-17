package com.naporaidersmoto.domain.service;

import com.naporaidersmoto.domain.Product;
import com.naporaidersmoto.domain.repository.ProductRepository;
import com.naporaidersmoto.persitence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getByName(String productName) {
        return productRepository.getByName(productName);
    }

    public Optional<Product> getByProductId(int productId) {
        return productRepository.getByProductId(productId);
    }

    public Optional<List<Product>> findByQuantity(int quantity) {
        return productRepository.findByQuantity(quantity);
    }

    public Optional<List<Product>> findByPrice(double price) {
        return productRepository.findByPrice(price);

    }

    public Optional<List<Product>> findBySaleId(int saleID) {
        return productRepository.findBySaleId(saleID);
    }

    public Optional<List<Product>> findBySupplierId(int supplierId) {
        return productRepository.findBySupplierId(supplierId);

    }
    public boolean delete(int productId) {
        return getByProductId(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }

}

