package com.nozha.sports.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nozha.sports.entities.Categorie;
import com.nozha.sports.entities.Sport;
import com.nozha.sports.repos.SportRepository;


@Service
public class SportServiceImpl implements SportService{

	@Autowired
	SportRepository sportRepository;
	
	@Override
	public Sport saveSport(Sport p) {
		return sportRepository.save(p);
	}

	@Override
	public Sport updateSport(Sport p) {
		return sportRepository.save(p);
	}

	@Override
	public void deleteSport(Sport p) {
		sportRepository.delete(p);
		
	}

	@Override
	public void deleteSportById(Long id) {
		sportRepository.deleteById(id);
		
	}

	@Override
	public Sport getSport(Long id) {
		return sportRepository.findById(id).get();
	}

	@Override
	public List<Sport> getAllSports() {
		
		return sportRepository.findAll();
	}

	@Override
	public List<Sport> findByNomSport(String nom) {
		
		return sportRepository.findByNomSport(nom);
	}

	@Override
	public List<Sport> findByNomSportContains(String nom) {
		
		return sportRepository.findByNomSportContains(nom);
	}

	@Override
	public List<Sport> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sport> findByCategorie(Categorie categorie) {
		
		return sportRepository.findByCategorie(categorie);
	}

	@Override
	public List<Sport> findByCategorieIdCat(Long id) {
	
		return sportRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Sport> findByOrderByNomSportAsc() {
		
		return sportRepository.findByOrderByNomSportAsc();
	}

	@Override
	public List<Sport> trierSportsNomsPrix() {
	
		return sportRepository.trierSportsNomsPrix();
	}
	
	

}
