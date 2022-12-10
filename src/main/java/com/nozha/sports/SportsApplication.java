package com.nozha.sports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.nozha.sports.entities.Categorie;
import com.nozha.sports.entities.Sport;

@SpringBootApplication
public class SportsApplication  implements CommandLineRunner{

	
	@Autowired
	 RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(SportsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Sport.class,Categorie.class);
		
		
	}

}
