package com.epam.spring.homework3.mapper;

import com.epam.spring.homework3.dto.ClientDTO;
import com.epam.spring.homework3.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;



@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO mapClientDTO (Client client);

    Client mapClient (ClientDTO clientDTO);

    List<ClientDTO> mapClientDTOs(List<Client> clients);
}