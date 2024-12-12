package com.istic.projet_spring.Miniprojet.model;

import jakarta.persistence.*;


@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String categorie;
    private String taille;
    private String couleur;
    private Double prix;
    private int stock;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_fabricant", nullable = false)
    private Fabricant fabricant;


    public Article() {
    }

    public Article(String nom, String categorie, String taille, String couleur, Double prix, int stock, String description, Fabricant fabricant) {
        this.nom = nom;
        this.categorie = categorie;
        this.taille = taille;
        this.couleur = couleur;
        this.prix = prix;
        this.stock = stock;
        this.description = description;
        this.fabricant = fabricant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }



    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Fabricant getFabricant() {
        return fabricant;
    }

    public void setFabricant(Fabricant fabricant) {
        this.fabricant = fabricant;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", categorie='" + categorie + '\'' +
                ", taille='" + taille + '\'' +
                ", couleur='" + couleur + '\'' +
                ", prix=" + prix +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", fabricant=" + fabricant +
                '}';
    }



}
