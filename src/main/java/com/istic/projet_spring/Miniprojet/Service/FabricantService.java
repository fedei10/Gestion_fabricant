package com.istic.projet_spring.Miniprojet.Service;

import com.istic.projet_spring.Miniprojet.model.Fabricant;
import com.istic.projet_spring.Miniprojet.repository.FabricantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricantService {
    @Autowired
    private FabricantRepository fabricantRepository;

    public FabricantService(FabricantRepository fabricantRepository) {
        this.fabricantRepository = fabricantRepository;
    }

    // Get all fabricants
    public List<Fabricant> getAllFabricants() {
        return fabricantRepository.findAll();
    }

    // Get a fabricant by ID
    public Fabricant getFabricantById(Long id) {
        return fabricantRepository.findById(id).orElse(null);
    }

    // Create a new fabricant
    public Fabricant createFabricant(Fabricant fabricant) {
        return fabricantRepository.save(fabricant);
    }

    // Delete a fabricant by ID
    public void deleteFabricant(Long id) {
        fabricantRepository.deleteById(id);
    }

    // Update an existing fabricant
    public Fabricant updateFabricant(Long id, Fabricant fabricant) {
        Fabricant existingFabricant = fabricantRepository.findById(id).orElse(null);
        if (existingFabricant != null) {
            existingFabricant.setNom(fabricant.getNom());
            existingFabricant.setAdresse(fabricant.getAdresse());
            existingFabricant.setTelephone(fabricant.getTelephone());
            return fabricantRepository.save(existingFabricant);
        }
        return null;
    }



    public List<Object[]> getTopFabricantsByNumberOfArticles() {
        return fabricantRepository.getTopFabricantsByNumberOfArticles();
    }

    public Long countTotalFabricants() {
        return fabricantRepository.countTotalFabricants();
    }





}
