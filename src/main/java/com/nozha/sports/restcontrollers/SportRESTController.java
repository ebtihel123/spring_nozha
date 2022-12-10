package com.nozha.sports.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nozha.sports.entities.Sport;
import com.nozha.sports.service.SportService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SportRESTController {
	
	@Autowired
	SportService sportService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Sport> getAllSports()
	{
		return sportService.getAllSports();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Sport getSportById(@PathVariable("id") Long id) {
		return sportService.getSport(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Sport createSport(@RequestBody Sport sport) {
			return sportService.saveSport(sport);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Sport updateSport(@RequestBody Sport sport) {
		return sportService.updateSport(sport);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteSport(@PathVariable("id") Long id)
	{
			sportService.deleteSportById(id);
	}
	
	@RequestMapping(value="prodscat/{idCat}",method = RequestMethod.GET)
	public List<Sport> getSportsByCatId(@PathVariable("idCat") Long idCat) {
		return sportService.findByCategorieIdCat(idCat);
	}
	@RequestMapping(value="/prodsByName/{nom}",method = RequestMethod.GET)
	public List<Sport> findByNomProduitContains(@PathVariable("nom") String nom) {
	return sportService.findByNomSportContains(nom);
	}  
	

	
	
	


}
