package com.naporaidersmoto.persitence.crud;

import com.naporaidersmoto.domain.Sale;
import com.naporaidersmoto.persitence.entity.Venta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VentaCrudRepository extends CrudRepository<Venta, Integer> {
    Optional<List<Venta>> findByIdCliente(int idCliente);
    Optional<Venta> findById(int integer);

}
