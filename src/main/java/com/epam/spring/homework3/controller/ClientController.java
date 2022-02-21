package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.ClientDTO;
import com.epam.spring.homework3.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/client/{id}")
    public ClientDTO getClient(@PathVariable int id) {
        log.info(this.getClass().getSimpleName() + ". Inside getClient method");
        return clientService.getClient(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/client")
    public List<ClientDTO> getAllClients() {
        log.info(this.getClass().getSimpleName() + ". Inside getAllClients method");
        return clientService.clientsList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/client")
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        log.info(this.getClass().getSimpleName() + ". Inside createClient method");
        return clientService.createClient(clientDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/client/{id}")
    public ClientDTO updateClient(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        log.info(this.getClass().getSimpleName() + ". Inside updateClient method");
        return clientService.updateClient(id, clientDTO);
    }

    @DeleteMapping(value = "/client/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable int id) {
        log.info(this.getClass().getSimpleName() + ". Inside deleteClient method");
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}