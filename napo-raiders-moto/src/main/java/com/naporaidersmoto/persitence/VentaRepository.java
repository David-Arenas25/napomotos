package com.naporaidersmoto.persitence;

import com.naporaidersmoto.domain.Sale;
import com.naporaidersmoto.domain.repository.SaleRepository;
import com.naporaidersmoto.persitence.crud.VentaCrudRepository;
import com.naporaidersmoto.persitence.entity.Venta;
import com.naporaidersmoto.persitence.mapper.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class VentaRepository implements SaleRepository {
    @Autowired
    private VentaCrudRepository ventaCrudRepository;

    @Autowired
    private SaleMapper mapper;

    @Override
    public List<Sale> getAll() {
        List<Venta> sales = (List<Venta>) ventaCrudRepository.findAll();
        return mapper.toSales(sales);
    }

    @Override
    public Optional<List<Sale>> getByClient(int clientId) {
        return ventaCrudRepository.findByIdCliente(clientId).map(ventas -> mapper.toSales(ventas));
    }

    @Override
    public Sale save(Sale sale) {
        Venta venta = mapper.toVenta(sale);
        Venta ventaGuardada = ventaCrudRepository.save(venta);
        return mapper.toSale(ventaGuardada);
    }


    @Override
    public Optional<Sale> getById(int saleId) {
        Optional<Venta> sales = ventaCrudRepository.findById(saleId);
        return sales.map(venta -> mapper.toSale(venta));
    }

    @Override
    public void delete(int saleId) {
        if (ventaCrudRepository.findById(saleId).isPresent()) {
            ventaCrudRepository.deleteById(saleId);
            System.out.println("Producto borrado");
        } else {
            System.out.println("Producto no encontrado");

        }


    }

    public VentaCrudRepository getVentaCrudRepository() {
        return ventaCrudRepository;
    }

    public void setVentaCrudRepository(VentaCrudRepository ventaCrudRepository) {
        this.ventaCrudRepository = ventaCrudRepository;
    }

    public SaleMapper getMapper() {
        return mapper;
    }

    public void setMapper(SaleMapper mapper) {
        this.mapper = mapper;
    }
}
