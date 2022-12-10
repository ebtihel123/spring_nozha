package com.nozha.sports.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomProd", types = { Sport.class })
public interface ProduitProjection {
	public String getNomProduit();

}
