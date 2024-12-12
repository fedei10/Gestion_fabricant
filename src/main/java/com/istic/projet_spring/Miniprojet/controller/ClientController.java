package com.istic.projet_spring.Miniprojet.controller;

import com.istic.projet_spring.Miniprojet.model.Client;
import com.istic.projet_spring.Miniprojet.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        if (clients == null || clients.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404 if no clients found
        }
        return ResponseEntity.ok(clients); // Return 200 with the list of clients
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        if (client == null) {
            return ResponseEntity.notFound().build(); // Return 404 if client not found
        }
        return ResponseEntity.ok(client); // Return 200 with the client
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientService.saveClient(client);
        if (createdClient == null) {
            return ResponseEntity.badRequest().build(); // Return 400 if creation failed
        }
        return ResponseEntity.ok(createdClient); // Return 200 with the created client
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        if (client == null) {
            return ResponseEntity.notFound().build(); // Return 404 if client not found
        }
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build(); // Return 204 on successful deletion
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(id, client);
        if (updatedClient == null) {
            return ResponseEntity.notFound().build(); // Return 404 if client not found
        }
        return ResponseEntity.ok(updatedClient); // Return 200 with the updated client
    }
}
