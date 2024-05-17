package com.naporaidersmoto.persitence.mapper;

import com.naporaidersmoto.domain.SaleItem;
import com.naporaidersmoto.persitence.entity.DetalleVenta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = SaleMapper.class)
public interface SaleItemMapper {

    @Mappings({
            @Mapping(source = "cantidadVendida", target = "quantitySold"),
            @Mapping(source = "precioUnitario", target = "unitPrice"),
            @Mapping(source = "totalVenta", target = "total")
    })
    SaleItem toSaleDetail(DetalleVenta venta);
    @InheritInverseConfiguration
    @Mappings({@Mapping(target = "producto", ignore = true),
            @Mapping(target = "venta",ignore = true)
    })

    DetalleVenta toDetalleVenta(SaleItem sale);


}