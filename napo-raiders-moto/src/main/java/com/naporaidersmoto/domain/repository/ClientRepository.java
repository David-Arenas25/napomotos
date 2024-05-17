package com.naporaidersmoto.domain.repository;
import com.naporaidersmoto.domain.Client;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    Client save(Client client);
    void deleteById(int clientId);
    Optional<Client> getById(int idCliente);
    Optional<Client> findByName(String clientName);
    void updateClientPhone(String clientPhone, int clientId);
    List<Client>getAll();
}
