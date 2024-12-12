package com.istic.projet_spring.Miniprojet.model;

import com.istic.projet_spring.Miniprojet.model.Purchase;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private boolean loyal;



    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isLoyal() {
        return loyal;
    }

    public void setLoyal(boolean loyal) {
        this.loyal = loyal;
    }



    @Override
    public String toString() {
        return "Client [id=" + id + ", nom=" + nom + ", email=" + email + ", loyal=" + loyal + "]";
    }




}
