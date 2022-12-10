package com.nozha.sports.service;

import java.util.List;

import com.nozha.sports.entities.Categorie;
import com.nozha.sports.entities.Sport;

public interface SportService {
	Sport saveSport(Sport p);
	Sport updateSport(Sport p);
	void deleteSport(Sport p);
	void deleteSportById(Long id);
	Sport getSport(Long id);
	List<Sport> getAllSports();
	List<Sport> findByNomSport(String nom);
	List<Sport> findByNomSportContains(String nom);
	List<Sport> findByNomPrix (String nom, Double prix);
	List<Sport> findByCategorie (Categorie categorie);
	List<Sport> findByCategorieIdCat(Long id);
	List<Sport> findByOrderByNomSportAsc();
	List<Sport> trierSportsNomsPrix();

}
