package com.naporaidersmoto.persitence.crud;

import com.naporaidersmoto.persitence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    Producto save(Producto producto);

    void deleteById(int idProducto);

    Optional<Producto> findByNombreProducto(String nombreProducto);

    Optional<Producto> findByIdProducto (int idProducto);

    Optional<List<Producto>> findByCantidadDisponibleLessThan(int cantidadDisponible);

    Optional<List<Producto>> findByPrecioUnitario (double precioUnitario);

    @Query(value = "select nombre_producto, id_compra from productos inner join compras on compras.id_producto = productos.id_producto where id_compra = ?", nativeQuery = true)
    Optional<List<Producto>> findByIdCompra(int idCompra);

    @Query(value = "select nombre_proveedor, nombre_producto, id_compra, fecha_compra, compras.precio_unitario from productos inner join compras on productos.id_producto = compras.id_producto inner join proveedores on proveedores.id_proveedor = compras.id_proveedor where id_proveedor = ?", nativeQuery = true)
    Optional<List<Producto>> findByIdProveedor(int idProveedor);
}



