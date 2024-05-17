package com.naporaidersmoto.domain.repository;

import com.naporaidersmoto.domain.Sale;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository {
    List<Sale> getAll();
    Optional<List<Sale>> getByClient(int clientId);
    Sale save(Sale sale);
    Optional<Sale> getById(int saleId);
    void delete(int saleId);
}
