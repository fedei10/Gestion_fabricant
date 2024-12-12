package com.istic.projet_spring.Miniprojet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.istic.projet_spring.Miniprojet.model.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>
{

    @Query(value = "SELECT * FROM article WHERE prix BETWEEN :minPrice AND :maxPrice", nativeQuery = true)
    List<Article> findArticlesByPriceRange(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);
    @Query(value = "SELECT * FROM article WHERE stock > :stock", nativeQuery = true)
    List<Article> findArticlesByStock(@Param("stock") int stock);

    @Query(value = "SELECT * FROM article WHERE fabricant_id = :fabricantId", nativeQuery = true)
    List<Article> findArticlesByFabricant(@Param("fabricantId") long fabricantId);

    @Query("SELECT a, COUNT(p) AS purchaseCount FROM Purchase p JOIN p.article a JOIN a.fabricant f WHERE f.id = :fabricantId GROUP BY a ORDER BY purchaseCount DESC")
    List<Object[]> findMostPurchasedArticlesByFabricant(@Param("fabricantId") Long fabricantId);

    //get the article with the most purchases
    @Query("SELECT a FROM Article a JOIN Purchase pa ON a.id = pa.article.id GROUP BY a ORDER BY COUNT(pa) DESC")
    List<Article> findMostPurchasedArticle();


}
