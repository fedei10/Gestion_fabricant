package com.istic.projet_spring.Miniprojet.controller;

import com.istic.projet_spring.Miniprojet.Service.FabricantService;
import com.istic.projet_spring.Miniprojet.model.Fabricant;
import com.istic.projet_spring.Miniprojet.repository.FabricantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restapi/fabricants")
public class fabricantController {
    @Autowired
    private FabricantRepository fabricantRepository;

    private FabricantService fabricantService;

   @GetMapping
    public ResponseEntity <List<Fabricant>> getAllFabricants() {
        List<Fabricant> fabricants = fabricantRepository.findAll();
        if (fabricants == null || fabricants.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404
        } else {
            return ResponseEntity.ok(fabricants); // Return 200
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricant> getFabricantById(@PathVariable Long id) {
        Fabricant fabricant = fabricantRepository.findById(id).orElse(null);
        if (fabricant == null) {
            return ResponseEntity.notFound().build(); // Return 404
        } else {
            return ResponseEntity.ok(fabricant); // Return 200
        }
    }

    @PostMapping
    public ResponseEntity<Fabricant> createFabricant(@RequestBody Fabricant fabricant) {
        return ResponseEntity.ok(fabricantRepository.save(fabricant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFabricant(@PathVariable Long id) {
        fabricantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricant> updateFabricant(@PathVariable Long id, @RequestBody Fabricant fabricant) {
        Fabricant existingFabricant = fabricantRepository.findById(id).orElse(null);
        existingFabricant.setNom(fabricant.getNom());
        existingFabricant.setAdresse(fabricant.getAdresse());
        existingFabricant.setTelephone(fabricant.getTelephone());
        fabricantRepository.save(existingFabricant);
        return ResponseEntity.ok(existingFabricant);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countTotalFabricants() {
        Long count = fabricantRepository.countTotalFabricants();
        if (count == null )  {
            return ResponseEntity.notFound().build();
        }else{

            return ResponseEntity.ok(count);
        }
    }


    @GetMapping("/top-by-articles")
    public List<Object[]> getTopFabricantsByNumberOfArticles() {
        return fabricantService.getTopFabricantsByNumberOfArticles();
    }









}