package com.istic.projet_spring.Miniprojet.model;

import com.istic.projet_spring.Miniprojet.model.Article;
import com.istic.projet_spring.Miniprojet.model.Client;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date purchaseDate;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    public Purchase() {
    }


    public Purchase(Date purchaseDate, double amount, Client client, Article article) {
        this.purchaseDate = purchaseDate;
        this.amount = amount;
        this.client = client;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }


    public void set(Date date) {
    }
    public Date getDate() {
        return purchaseDate;
    }


    @Override
    public String toString() {
        return "Purchase [id=" + id + ", purchaseDate=" + purchaseDate + ", amount=" + amount + ", client=" + client + ", article=" + article + "]";
    }





}
