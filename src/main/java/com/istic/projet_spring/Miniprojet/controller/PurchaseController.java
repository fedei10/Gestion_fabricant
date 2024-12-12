package com.istic.projet_spring.Miniprojet.controller;

import com.istic.projet_spring.Miniprojet.Service.PurchaseService;
import com.istic.projet_spring.Miniprojet.model.Client;
import com.istic.projet_spring.Miniprojet.model.Fabricant;
import com.istic.projet_spring.Miniprojet.model.Purchase;
import com.istic.projet_spring.Miniprojet.repository.FabricantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restapi/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private com.istic.projet_spring.Miniprojet.repository.purchaseRepository purchaseRepository;

    @GetMapping
    public ResponseEntity getAllPurchases() {
        List<Purchase> purchases = purchaseService.getAllPurchases();
        if (purchases == null || purchases.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404
        } else {
            return ResponseEntity.ok(purchases); // Return 200
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getPurchaseById(@PathVariable Long id) {
        Purchase purchase = purchaseService.getPurchaseById(id);
        if (purchase == null) {
            return ResponseEntity.notFound().build(); // Return 404
        } else {
            return ResponseEntity.ok(purchase); // Return 200
        }
    }

    @PostMapping
    public ResponseEntity createPurchase(@RequestBody Purchase purchase) {
        Purchase createdPurchase = purchaseService.savePurchase(purchase);
        if (createdPurchase == null) {
            return ResponseEntity.badRequest().build(); // Return 400 if purchase not created
        }else {
            return ResponseEntity.ok(createdPurchase); // Return 200 with the created purchase
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePurchase(@PathVariable Long id) {
        Purchase deletedPurchase =purchaseService.deletePurchase(id);
        if (deletedPurchase == null) {
            return ResponseEntity.notFound().build(); // Return 404 if purchase not found
        }
        else {
            return ResponseEntity.noContent().build(); // Return 204
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePurchase(@PathVariable Long id, @RequestBody Purchase purchase) {
        Purchase updatedPurchase = purchaseService.updatePurchase(id, purchase);
        if (updatedPurchase == null) {
            return ResponseEntity.notFound().build(); // Return 404 if purchase not found
        }
        else {
            return ResponseEntity.ok(updatedPurchase); // Return 200
        }
    }


    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Purchase>> getPurchasesByClient(@PathVariable Long clientId) {
        List<Purchase> purchases = purchaseService.getPurchasesByClient(clientId);
        if (purchases == null || purchases.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(purchases);
    }

    @GetMapping("count/{clientId}")
    public ResponseEntity<Long> countPurchasesByClient(@PathVariable Long clientId) {
        Long count = purchaseRepository.countPurchasesByClient(clientId);
        if (count == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(count);
    }

    @GetMapping("/revenue")
    public ResponseEntity<Double> getTotalRevenue() {
        Double revenue = purchaseRepository.getTotalRevenue();
        if (revenue == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(revenue);
    }

    @GetMapping("/purchase/{clientId}")
    public ResponseEntity<Double> getTotalRevenueByClientId(@PathVariable Long clientId) {
        Double revenue = purchaseRepository.getTotalRevenueByClientId(clientId);
        if (revenue == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(revenue);
    }



}
