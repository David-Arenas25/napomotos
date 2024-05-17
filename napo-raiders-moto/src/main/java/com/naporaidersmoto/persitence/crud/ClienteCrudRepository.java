package com.naporaidersmoto.persitence.crud;

import com.naporaidersmoto.persitence.entity.Cliente;
import com.naporaidersmoto.persitence.entity.Compra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente,Integer> {
    Optional<Cliente> findByIdCliente(int idCliente);
    Optional<Cliente> findByNombreCliente(String nombreCliente);
    @Query(value = "Update clientes set telefono_cliente = ? where id_cliente = ?",nativeQuery = true)
    void updateTelefonoCliente(String telefonoCliente, int idCliente);
    Cliente save(Cliente cliente);
    void deleteById(int clientId);

}
