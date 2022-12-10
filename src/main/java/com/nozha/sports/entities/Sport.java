package com.nozha.sports.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sport {	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idSport;
	private String nomSport;
	private Double prixSport;
	private Date dateCreation;
	
	@ManyToOne
	private Categorie categorie;

	public Sport() {
		super();
	}
	
	
	public Sport(String nomSport, Double prixSport, Date dateCreation) {
		super();
		this.nomSport = nomSport;
		this.prixSport = prixSport;
		this.dateCreation = dateCreation;
	}


	public Long getIdSport() {
		return idSport;
	}
	public void setIdSport(Long idSport) {
		this.idSport = idSport;
	}
	public String getNomSport() {
		return nomSport;
	}
	public void setNomSport(String nomSport) {
		this.nomSport = nomSport;
	}
	public Double getPrixSport() {
		return prixSport;
	}
	public void setPrixSport(Double prixSport) {
		this.prixSport = prixSport;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	@Override
	public String toString() {
		return "Sport [idSport=" + idSport + ", nomSport=" + nomSport + ", prixSport=" + prixSport
				+ ", dateCreation=" + dateCreation + "]";
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	

}
