package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.ClientDTO;
import com.epam.spring.homework3.mapper.ClientMapper;
import com.epam.spring.homework3.model.Client;
import com.epam.spring.homework3.repository.ClientRepository;
import com.epam.spring.homework3.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public ClientDTO getClient(int id) {
        log.info(this.getClass().getSimpleName() + ". Inside getClient method");
        Client client = clientRepository.getClient(id);
        return ClientMapper.INSTANCE.mapClientDTO(client);
    }

    @Override
    public List<ClientDTO> clientsList() {
        log.info(this.getClass().getSimpleName() + ". Inside clientsList method");
        return ClientMapper.INSTANCE.mapClientDTOs(clientRepository.clientsList());
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        log.info(this.getClass().getSimpleName() + ". Inside createClient method");
        Client client = ClientMapper.INSTANCE.mapClient(clientDTO);
        client = clientRepository.createClient(client);
        return ClientMapper.INSTANCE.mapClientDTO(client);
    }

    @Override
    public ClientDTO updateClient(int id, ClientDTO clientDTO) {
        log.info(this.getClass().getSimpleName() + ". Inside updateClient method");
        Client client = ClientMapper.INSTANCE.mapClient(clientDTO);
        client = clientRepository.updateClient(id, client);
        return ClientMapper.INSTANCE.mapClientDTO(client);
    }

    @Override
    public void deleteClient(int id) {
        log.info(this.getClass().getSimpleName() + ". Inside deleteClient method");
        clientRepository.deleteClient(id);
    }
}
