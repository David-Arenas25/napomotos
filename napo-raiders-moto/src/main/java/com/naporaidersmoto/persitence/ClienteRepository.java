package com.naporaidersmoto.persitence;

import com.naporaidersmoto.domain.Client;
import com.naporaidersmoto.domain.repository.ClientRepository;
import com.naporaidersmoto.persitence.crud.ClienteCrudRepository;
import com.naporaidersmoto.persitence.entity.Cliente;
import com.naporaidersmoto.persitence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Autowired
    private ClientMapper mapper;


    @Override
    public Client save(Client client) {
        Cliente cliente = mapper.toCliente(client);
        cliente = clienteCrudRepository.save(cliente);
        return mapper.toClient(cliente);
    }


    @Override
    public void deleteById(int clientId) {
        clienteCrudRepository.deleteById(clientId);

    }

    @Override
    public Optional<Client> getById(int idCliente) {
        return clienteCrudRepository.findByIdCliente(idCliente).map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public Optional<Client> findByName(String clientName) {
        return clienteCrudRepository.findByNombreCliente(clientName).map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public void updateClientPhone(String clientPhone, int clientId) {
        clienteCrudRepository.updateTelefonoCliente(clientPhone,clientId);

    }


    @Override
    public List<Client> getAll() {
        List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
        return mapper.toClients(clientes);
    }



}
