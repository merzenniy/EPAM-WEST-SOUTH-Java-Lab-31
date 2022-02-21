package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.exception.ItemNotFoundException;
import com.epam.spring.homework3.model.Client;
import com.epam.spring.homework3.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class ClientRepositoryImpl implements ClientRepository {
    private final List<Client> clients = new ArrayList<>();

    @Override
    public Client getClient(int id) {
        log.info(this.getClass().getSimpleName() + ". Inside getClient method");
        return clients.stream()
                .filter(client -> client.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Can`t found client with id = " + id));
    }

    @Override
    public List<Client> clientsList() {
        log.info(this.getClass().getSimpleName() + ". Inside clientsList method");
        return new ArrayList<>(clients);
    }

    @Override
    public Client createClient(Client client) {
        log.info(this.getClass().getSimpleName() + ". Inside createClient method");
        clients.add(client);
        return client;
    }

    @Override
    public Client updateClient(int id, Client client) {
        log.info(this.getClass().getSimpleName() + ". Inside updateClient method");
        boolean isChanged = clients.removeIf(client1 -> client1.getId() == id);
        if (isChanged) {
            clients.add(client);
        } else {
            throw new ItemNotFoundException("Сlient with given id does not exist");
        }
        return client;
    }

    @Override
    public void deleteClient(int id) {
        log.info(this.getClass().getSimpleName() + ". Inside deleteClient method");
        clients.removeIf(client -> client.getId() == id);
    }
}
