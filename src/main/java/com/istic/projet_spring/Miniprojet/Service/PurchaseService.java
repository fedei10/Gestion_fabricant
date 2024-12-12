package com.istic.projet_spring.Miniprojet.Service;

import com.istic.projet_spring.Miniprojet.model.Client;
import com.istic.projet_spring.Miniprojet.model.Purchase;
import com.istic.projet_spring.Miniprojet.repository.ClientRepository;
import com.istic.projet_spring.Miniprojet.repository.purchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private purchaseRepository purchaseRepository;
    @Autowired
    private ClientRepository clientRepository;

    // Get all purchases
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    // Get a purchase by ID
    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    // Save a new purchase and update loyalty status
    public Purchase savePurchase(Purchase purchase) {
        Purchase savedPurchase = purchaseRepository.save(purchase);
        updateClientLoyaltyStatus(purchase.getClient().getId());
        return savedPurchase;
    }

    // Update an existing purchase
    public Purchase updatePurchase(Long id, Purchase purchase) {
        Purchase existingPurchase = purchaseRepository.findById(id).orElse(null);
        if (existingPurchase != null) {
            existingPurchase.setArticle(purchase.getArticle());
            existingPurchase.setClient(purchase.getClient());
            existingPurchase.setAmount(purchase.getAmount());
            existingPurchase.setPurchaseDate(purchase.getPurchaseDate());
            return purchaseRepository.save(existingPurchase);
        }
        return null;
    }

    // Delete a purchase
    public Purchase deletePurchase(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElse(null);
        if (purchase != null) {
            purchaseRepository.deleteById(id);
        }
        return purchase;
    }

    // Check if a client becomes loyal and apply a discount
    private void updateClientLoyaltyStatus(Long clientId) {
        Long purchaseCount = purchaseRepository.countPurchasesByClientId(clientId);
        if (purchaseCount >= 20) {
            Client client = clientRepository.findById(clientId).orElse(null);
            if (client != null && !client.isLoyal()) {
                client.setLoyal(true);
                clientRepository.save(client);
            }
        }
    }

    // Get total revenue
    public Double getTotalRevenue() {
        return purchaseRepository.getTotalRevenue();
    }

    public List<Purchase> getPurchasesByClient(Long clientId) {
        return purchaseRepository.findByClientId(clientId);
    }

    public Long countPurchasesByClient(Long clientId) {
        return purchaseRepository.countPurchasesByClientId(clientId);
    }
    public  Double getTotalRevenueByClientId(Long clientId){
        return purchaseRepository.getTotalRevenueByClientId(clientId);
    }





}