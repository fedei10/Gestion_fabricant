package com.istic.projet_spring.Miniprojet.Service;

import com.istic.projet_spring.Miniprojet.model.Client;
import com.istic.projet_spring.Miniprojet.model.Fabricant;
import com.istic.projet_spring.Miniprojet.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Client deletedClient = clientRepository.findById(id).orElse(null);
        if (deletedClient != null) {
            clientRepository.deleteClientById(id);
        }
    }

    public Client updateClient(Long id, Client client) {
        Client existingClient = clientRepository.findById(id).orElse(null);
        if (existingClient != null) {
            client.setId(id);
            return clientRepository.save(client);
        }
        return null;
    }

    public List<Client> getLoyalClientsByFabricant(Long fabricantId) {
        return clientRepository.findLoyalClientsByFabricant(fabricantId);
    }






}
