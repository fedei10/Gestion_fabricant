package com.istic.projet_spring.Miniprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.istic.projet_spring.Miniprojet.model.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT DISTINCT c FROM Client c JOIN Purchase p ON c.id = p.client.id JOIN p.article a JOIN a.fabricant f WHERE f.id = :fabricantId AND c.loyal = true")
    List<Client> findLoyalClientsByFabricant(@Param("fabricantId") Long fabricantId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM client WHERE id = :id", nativeQuery = true)
    void deleteClientById(@Param("id") Long id);



}