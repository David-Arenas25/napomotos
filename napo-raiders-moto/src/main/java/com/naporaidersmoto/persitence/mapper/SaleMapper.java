package com.naporaidersmoto.persitence.mapper;

import com.naporaidersmoto.domain.Sale;
import com.naporaidersmoto.persitence.entity.Venta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface SaleMapper {

    @Mappings({
            @Mapping(source = "idVenta" , target = "saleId"),
            @Mapping(source = "fechaVenta", target= "saleDate"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "totalVenta", target = "total")
    })
    Sale toSale(Venta venta);

    List<Sale> toSales(List<Venta> ventas); // Corrección aquí

    @InheritInverseConfiguration
    Venta toVenta(Sale sale);
}
