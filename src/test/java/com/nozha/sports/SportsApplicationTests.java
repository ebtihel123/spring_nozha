package com.nozha.sports;



import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nozha.sports.entities.Categorie;
import com.nozha.sports.entities.Sport;
import com.nozha.sports.repos.SportRepository;


@SpringBootTest
class SportsApplicationTests {

	@Autowired
	private SportRepository sportRepository;
	
	@Test
	public void testCreateSport() {
	Sport spo = new Sport("dance",250.500,new Date());
	sportRepository.save(spo);
	}
	
	@Test
	public void testFindSport()
	{
	Sport p = sportRepository.findById(1L).get();
	System.out.println(p);
	}
	
	@Test
	public void testUpdateSport()
	{
	Sport p = sportRepository.findById(2L).get();
	p.setPrixSport(200.0);
	sportRepository.save(p);
	
	System.out.println(p);
	}
	
	@Test
	public void testDeleteSport()
	{
		sportRepository.deleteById(3L);
	}
	
	@Test
	public void testFindAllSports()
	{
		List<Sport> spos = sportRepository.findAll();
		
		for (Sport p:spos)
			 System.out.println(p);
		
	}
	
	
	@Test
	public void testFindSportByNom()
	{
	List<Sport> spos = sportRepository.findByNomSport("acrobique");
	
	for (Sport p:spos)
		 System.out.println(p);
	
	}
	
	@Test
	public void testFindSportByNomContains()
	{
	List<Sport> spos = sportRepository.findByNomSportContains("P");
	
	for (Sport p:spos)
		 System.out.println(p);
	
	}
	
	@Test
	public void testfindByNomPrix()
	{
	List<Sport> spos = sportRepository.findByNomPrix("a", 150.500);
		for (Sport p : spos)
			{
				System.out.println(p);
			}
	}
	
	
	@Test
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	
	List<Sport> spos = sportRepository.findByCategorie(cat);
	for (Sport p : spos)
	{
		System.out.println(p);
	}
	}
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Sport> spos = sportRepository.findByCategorieIdCat(1L);
	for (Sport p : spos)
	{
		System.out.println(p);
	}
	}
	
	
	@Test
	public void testfindByOrderByNomSportAsc()
	{
	List<Sport> spos =  sportRepository.findByOrderByNomSportAsc();
	for (Sport p : spos)
		{
			System.out.println(p);
		}
	}
	
	@Test
	public void testTrierSportsNomsPrix()
	{
	List<Sport> spos = sportRepository.trierSportsNomsPrix();
	for (Sport p : spos)
	{
	System.out.println(p);
	}
	}
	
	
}
