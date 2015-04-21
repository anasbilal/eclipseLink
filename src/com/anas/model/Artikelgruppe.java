package com.anas.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the artikelgruppe database table.
 * 
 */
@Entity
@Table(name="artikelgruppe")
@NamedQueries({
    @NamedQuery(name="Artikelgruppe.findAll", 
    		query="SELECT a FROM Artikelgruppe a"),
    @NamedQuery(name="Artikelgruppe.delete", 
    query="DELETE FROM Artikelgruppe a WHERE a.name = :nameParam")
})
		
public class Artikelgruppe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="artgruppe_id", unique=true, nullable=false)
	private int artgruppeId;

	@Column(length=20)
	private String name;

	//bi-directional many-to-one association to Artikel
	@OneToMany(mappedBy="artikelgruppe")
	private List<Artikel> artikels = new ArrayList<Artikel>();

	public Artikelgruppe() {
	}

	public int getArtgruppeId() {
		return this.artgruppeId;
	}

	public void setArtgruppeId(int artgruppeId) {
		this.artgruppeId = artgruppeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Artikel> getArtikels() {
		return this.artikels;
	}

	public void setArtikels(List<Artikel> artikels) {
		this.artikels = artikels;
	}

	public Artikel addArtikel(Artikel artikel) {
		getArtikels().add(artikel);
		artikel.setArtikelgruppe(this);

		return artikel;
	}

	public Artikel removeArtikel(Artikel artikel) {
		//getArtikels().remove(artikel);
		artikel.setArtikelgruppe(null);

		return artikel;
	}

}