package com.naporaidersmoto.domain.repository;

import com.naporaidersmoto.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    void delete(int productId);
    List<Product> getAll();

    Optional<Product> getByName(String productName);

    Optional<Product> getByProductId (int productId);

    Optional<List<Product>> findByQuantity(int quantity);

    Optional<List<Product>> findByPrice(double price);

    Optional<List<Product>> findBySaleId(int saleID);

    Optional<List<Product>> findBySupplierId(int supplierId);


}
