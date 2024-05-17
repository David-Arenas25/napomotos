package com.naporaidersmoto.domain.service;

import com.naporaidersmoto.domain.Sale;
import com.naporaidersmoto.domain.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;


    public List<Sale> getAll() {
        return saleRepository.getAll();
    }

    public Optional<List<Sale>> getByClient(int clientId) {
        return saleRepository.getByClient(clientId);
    }

    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    public Optional<Sale> getById(int saleId) {
        return saleRepository.getById(saleId);
    }

    public void delete(int saleId) {
        saleRepository.delete(saleId);
    }

    public SaleRepository getSaleRepository() {
        return saleRepository;
    }

    public void setSaleRepository(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }
}
