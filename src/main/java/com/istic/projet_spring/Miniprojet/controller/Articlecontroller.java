package com.istic.projet_spring.Miniprojet.controller;

import com.istic.projet_spring.Miniprojet.model.Article;
import com.istic.projet_spring.Miniprojet.Service.ArticleService;
import com.istic.projet_spring.Miniprojet.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class Articlecontroller {
    @Autowired
    private ArticleService articleService;
     @Autowired
    private ArticleRepository articleRepository;


    //get all
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        if (articles == null || articles.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404
        } else {
            return ResponseEntity.ok(articles); // Return 200
        }
    }


    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        if (article == null) {
            return ResponseEntity.notFound().build(); // Return 404
        } else {
            return ResponseEntity.ok(article); // Return 200
        }
    }

    //post article
    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article createdArticle = articleService.saveArticle(article);
        if (createdArticle == null) {
            return ResponseEntity.badRequest().build(); // Return 400 if article not created
        }else {
            return ResponseEntity.ok(createdArticle); // Return 200 with the created article
        }

    }

    //delete Mapping
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        Article deletedArticle =articleService.deleteArticle(id);
        if (deletedArticle == null) {
            return ResponseEntity.notFound().build(); // Return 404 if article not found
        }
        else {
            return ResponseEntity.noContent().build(); // Return 204
        }
        }


    //update
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article article) {
        Article updatedArticle = articleService.updateArticle(id, article);
        if (updatedArticle == null) {
            return ResponseEntity.notFound().build(); // Return 404 if article not found
        } else {
            return ResponseEntity.ok(updatedArticle); // Return 200 with the updated article
        }
    }



    //get article by price range
    @GetMapping("/price-range")
    public ResponseEntity<List<Article>> getArticlesByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<Article> articles = articleService.getArticlesByPriceRange(minPrice, maxPrice);
        if (articles == null || articles.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404
        } else {
            return ResponseEntity.ok(articles); // Return 200
        }
    }



    @GetMapping("/stock")
    public ResponseEntity<List<Article>> getArticlesByStock(@RequestParam int stock) {
        List<Article> articles = articleService.getArticlesByStock(stock);
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 if no articles found
        } else {
            return ResponseEntity.ok(articles); // Return 200 with the list of articles
        }
    }



    @GetMapping("/most-purchased/{fabricantId}")
    public List<Object[]> getMostPurchasedArticlesByFabricant(@PathVariable Long fabricantId) {
        return articleService.getMostPurchasedArticlesByFabricant(fabricantId);
    }

    @GetMapping("/mostar")
    public List<Article> getMostPurchasedArticle() {
        return articleRepository.findMostPurchasedArticle();
    }


}