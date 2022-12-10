package com.nozha.sports.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nozha.sports.entities.Categorie;
import com.nozha.sports.entities.Sport;

@RepositoryRestResource(path = "rest")
public interface SportRepository extends JpaRepository<Sport, Long> {
	
	List<Sport> findByNomSport(String nom);
	List<Sport> findByNomSportContains(String nom);
	
	/*@Query("select p from Sport p where p.nomSport like %?1 and p.prixSport > ?2")
	List<Sport> findByNomPrix (String nom, Double prix);*/
	
	@Query("select p from Sport p where p.nomSport like %:nom and p.prixSport > :prix")
	List<Sport> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

	@Query("select p from Sport p where p.categorie = ?1")
	List<Sport> findByCategorie (Categorie categorie);
	
	List<Sport> findByCategorieIdCat(Long id);
	
	List<Sport> findByOrderByNomSportAsc();
	
	@Query("select p from Sport p order by p.nomSport ASC, p.prixSport DESC")
	List<Sport> trierSportsNomsPrix ();

}
