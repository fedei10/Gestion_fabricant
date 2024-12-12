package com.istic.projet_spring.Miniprojet.Service;

import com.istic.projet_spring.Miniprojet.model.Article;
import com.istic.projet_spring.Miniprojet.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article deleteArticle(Long id) {
        articleRepository.deleteById(id);
        return null;
    }
    public Article updateArticle(Long id, Article article) {
        Article existingArticle = articleRepository.findById(id).orElse(null);
        existingArticle.setNom(article.getNom());
        existingArticle.setPrix(article.getPrix());
        existingArticle.setStock(article.getStock());
        articleRepository.save(existingArticle);
        return existingArticle;
    }

    public List<Article> getArticlesByPriceRange(double minPrice, double maxPrice) {
        return articleRepository.findArticlesByPriceRange(minPrice, maxPrice);
    }



    public List<Article> getArticlesByStock(int stock) {
        return articleRepository.findArticlesByStock(stock);
    }





    public List<Object[]> getMostPurchasedArticlesByFabricant(Long fabricantId) {
        return articleRepository.findMostPurchasedArticlesByFabricant(fabricantId);
    }

    public List<Article> getArticlesByFabricant(Long fabricantId) {
        return articleRepository.findArticlesByFabricant(fabricantId);
    }

    //find most purchased article
    public List<Article> getMostPurchasedArticle() {
        return articleRepository.findMostPurchasedArticle();
    }

}

