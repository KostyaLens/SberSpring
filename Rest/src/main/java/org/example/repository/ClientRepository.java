package org.example.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.emptity.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class ClientRepository {
    private List<Client> clientList = new ArrayList<Client>();
    private long id = -1;
    public void singClient(Client client){
        id++;
        client.setId(id);
        clientList.add(client);
    }

    public Optional<Client> getClient(long id){
        return Optional.ofNullable(clientList.stream().filter(client -> client.getId() == id).findAny().orElse(null));
    }

    public Client isClient(Client client) {
        return clientList.stream()
                .filter(x -> x.getLogin() != client.getLogin()).findAny().orElse(null);
    }
}
