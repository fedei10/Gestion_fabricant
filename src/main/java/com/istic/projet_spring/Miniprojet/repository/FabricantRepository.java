package com.istic.projet_spring.Miniprojet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.istic.projet_spring.Miniprojet.model.Fabricant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FabricantRepository extends JpaRepository<Fabricant, Long>
{
    //calculer le nombre total de fabricants
    @Query("SELECT COUNT(f) FROM Fabricant f")
    Long countTotalFabricants();



    @Query("SELECT f, COUNT(a) AS articleCount FROM Article a JOIN a.fabricant f GROUP BY f ORDER BY articleCount DESC")
    List<Object[]> getTopFabricantsByNumberOfArticles();






}
