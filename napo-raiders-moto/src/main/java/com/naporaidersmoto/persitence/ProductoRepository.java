package com.naporaidersmoto.persitence;

import com.naporaidersmoto.domain.Product;
import com.naporaidersmoto.domain.repository.ProductRepository;
import com.naporaidersmoto.persitence.crud.ProductoCrudRepository;
import com.naporaidersmoto.persitence.entity.Producto;
import com.naporaidersmoto.persitence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        producto = productoCrudRepository.save(producto);
        return mapper.toProduct(producto);
    }


    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<Product> getByName(String productName) {
        Optional<Producto> producto = productoCrudRepository.findByNombreProducto(productName);
        return producto.map(producto1 -> mapper.toProduct(producto1));
    }

    @Override
    public Optional<Product> getByProductId(int productId) {
         return productoCrudRepository.findByIdProducto(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Optional<List<Product>> findByQuantity(int quantity) {
        return productoCrudRepository.findByCantidadDisponibleLessThan(quantity).map(productos -> mapper.toProducts(productos));

    }

    @Override
    public Optional<List<Product>> findByPrice(double price) {
        return productoCrudRepository.findByPrecioUnitario(price).map(productos -> mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> findBySaleId(int saleID) {
        return productoCrudRepository.findByIdCompra(saleID).map(productos -> mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> findBySupplierId(int supplierId) {
        return productoCrudRepository.findByIdProveedor(supplierId).map(productos -> mapper.toProducts(productos));


    }


}

