package com.naporaidersmoto.domain.service;

import com.naporaidersmoto.domain.Client;
import com.naporaidersmoto.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getByName(String clientName){
        return clientRepository.findByName(clientName);
    };
    public Client save(Client client){
        return clientRepository.save(client);
    }
    public Optional<Client> getById(int saleId){
        return clientRepository.getById(saleId);
    }
    public void deleteById(int saleId){
        clientRepository.deleteById(saleId);
    }

    public void updatePhone( String clientPhone, int clientId){
        clientRepository.updateClientPhone(clientPhone, clientId);
    }

}
