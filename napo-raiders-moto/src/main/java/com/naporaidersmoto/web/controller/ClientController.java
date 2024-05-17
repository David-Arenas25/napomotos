package com.naporaidersmoto.web.controller;

import com.naporaidersmoto.domain.Client;
import com.naporaidersmoto.domain.service.ClientService;
import com.naporaidersmoto.persitence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity getAll(){
        return new ResponseEntity(clientService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idClient}")
    public void deleteById(@PathVariable int idClient){
        clientService.deleteById(idClient);
    }

    @PostMapping("/save")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        Client cliente = clientService.save(client);
        return new ResponseEntity<>(cliente,HttpStatus.CREATED);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Client> getByName(@PathVariable String clientName){
            Optional<Client> client = clientService.getByName(clientName);
            if (client.isPresent()){
                return ResponseEntity.of(client);
            }else {
                return (ResponseEntity<Client>) ResponseEntity.notFound();
            }
    }

    @GetMapping("updatephone/{phone}")
    public ResponseEntity updatePhone(@PathVariable String clientPhone, int clientId) {
        if (clientService.getById(clientId).isPresent()) {
            clientService.updatePhone(clientPhone, clientId);
            return new ResponseEntity(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getbyid/{id}")
    public ResponseEntity getById(@PathVariable int clientId){
        return new ResponseEntity<>(clientService.getById(clientId), HttpStatus.OK);
    }

}




