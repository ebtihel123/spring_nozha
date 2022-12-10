package com.nozha.sports.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nozha.sports.entities.Sport;
import com.nozha.sports.service.SportService;

@Controller
public class SportController {
	
	
	@Autowired
	SportService sportService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createSport";
	}
	
	@RequestMapping("/saveSport")
	public String saveSport(@ModelAttribute("sport") Sport sport,
							  @RequestParam("date") String date,
	                          ModelMap modelMap) throws 	ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	sport.setDateCreation(dateCreation);
	
	Sport saveSport = sportService.saveSport(sport);
	String msg ="sport enregistré avec Id "+saveSport.getIdSport();
	modelMap.addAttribute("msg", msg);
	return "createSport";
	}
	
	@RequestMapping("/ListeSports")
	public String listeSports(ModelMap modelMap)
	{
		List<Sport> spos = sportService.getAllSports();
		modelMap.addAttribute("sports", spos);
		return "listeSports";
	}
	
	@RequestMapping("/supprimerSport")
	public String supprimerSport(@RequestParam("id") Long id,
	ModelMap modelMap)
	{
		sportService.deleteSportById(id);
		List<Sport> spos = sportService.getAllSports();
		modelMap.addAttribute("sports", spos);
	return "listeSports";
	}
	
	@RequestMapping("/modifierSport")
	public String editerSport(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Sport p= sportService.getSport(id);
	modelMap.addAttribute("sport", p);
	return "editerSport";
	}
	
	@RequestMapping("/updateSport")
	public String updateSport(@ModelAttribute("sport") Sport sport,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	sport.setDateCreation(dateCreation);
	sportService.updateSport(sport);
	List<Sport> spos = sportService.getAllSports();
	modelMap.addAttribute("sports", spos);
	return "listeSports";
	}
	


}
