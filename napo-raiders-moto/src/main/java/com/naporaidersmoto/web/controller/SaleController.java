package com.naporaidersmoto.web.controller;

import com.naporaidersmoto.domain.Sale;
import com.naporaidersmoto.domain.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")

public class SaleController {
    @Autowired
    private SaleService saleService;


    @GetMapping("/all")
    public ResponseEntity<List<Sale>> getAll() {
        return new ResponseEntity<>(saleService.getAll(), HttpStatus.OK);
    }
    @GetMapping("client/{client}")

    public ResponseEntity<List<Sale>> getByClient(@PathVariable("client") int clientId) {
        return ResponseEntity.of(saleService.getByClient(clientId));
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Sale sale) {
        return new ResponseEntity<>(saleService.save(sale),HttpStatus.CREATED);
    }
    @GetMapping("sale/{sale}")
    public ResponseEntity<Sale> getById(@PathVariable("sale") int saleId) {
        return ResponseEntity.of(saleService.getById(saleId));
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") int saleId) {
        saleService.delete(saleId);
    }

    public SaleService getSaleService() {
        return saleService;
    }

    public void setSaleService(SaleService saleService) {
        this.saleService = saleService;
    }
}
