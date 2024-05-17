package com.naporaidersmoto.persitence.mapper;
import com.naporaidersmoto.domain.Product;
import com.naporaidersmoto.persitence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SaleItemMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "idProduct"),
            @Mapping(source = "nombreProducto", target = "productName"),
            @Mapping(source = "descripcionProducto", target = "productInfo"),
            @Mapping(source = "precioUnitario", target = "productPrice"),
            @Mapping(source = "cantidadDisponible", target = "productStock")
    })
    Product toProduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    // Invertir la configuración para convertir Product a Producto
    @InheritInverseConfiguration
    Producto toProducto(Product product);
}
