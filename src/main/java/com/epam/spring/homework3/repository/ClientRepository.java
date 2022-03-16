package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.Client;

import java.util.List;

public interface ClientRepository {
    Client getClient(int id);

    List<Client> getClientsList();

    Client createClient(Client client);

    Client updateClient(int id, Client client);

    void deleteClient(int id);
}
