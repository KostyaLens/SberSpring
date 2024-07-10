package org.example.services;

import org.example.emptity.Client;
import org.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client){
        if(clientRepository.isClient(client) == null){
            return null;
        }
        clientRepository.singClient(client);
        return client;
    }

    public Optional<Client> searchClient(long id) {
        return clientRepository.getClient(id);
    }
}