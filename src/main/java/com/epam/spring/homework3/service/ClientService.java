package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO getClient(int id);

    List<ClientDTO> clientsList();

    ClientDTO createClient(ClientDTO clientDTO);

    ClientDTO updateClient(int id, ClientDTO clientDTO);

    void deleteClient(int id);
}
