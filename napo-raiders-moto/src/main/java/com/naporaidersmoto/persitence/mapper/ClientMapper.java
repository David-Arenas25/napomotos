package com.naporaidersmoto.persitence.mapper;

import com.naporaidersmoto.domain.Client;
import com.naporaidersmoto.persitence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = SaleMapper.class)
public interface ClientMapper {
    @Mappings({
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "nombreCliente", target = "clientName"),
            @Mapping(source = "direccionCliente", target= "clientAddress"),
            @Mapping(source = "telefonoCliente", target = "clientPhone"),
            @Mapping(source = "correoCliente", target= "clientEmail"),


    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente(Client client);



}
