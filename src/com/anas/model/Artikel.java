package com.anas.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the artikel database table.
 * 
 */
@Entity
@Table(name="artikel")
@NamedQuery(name="Artikel.findAll", query="SELECT a FROM Artikel a")
public class Artikel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="artikel_id", unique=true, nullable=false)
	private int artikelId;

	@Temporal(TemporalType.DATE)
	private Date artikelbaujahr;

	@Temporal(TemporalType.DATE)
	private Date autobaujahr;

	@Column(length=10)
	private String automarke;

	@Column(length=20)
	private String name;

	//bi-directional many-to-one association to Artikelgruppe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="artgruppe_id")
	private Artikelgruppe artikelgruppe;

	public Artikel() {
	}

	public int getArtikelId() {
		return this.artikelId;
	}

	public void setArtikelId(int artikelId) {
		this.artikelId = artikelId;
	}

	public Date getArtikelbaujahr() {
		return this.artikelbaujahr;
	}

	public void setArtikelbaujahr(Date artikelbaujahr) {
		this.artikelbaujahr = artikelbaujahr;
	}

	public Date getAutobaujahr() {
		return this.autobaujahr;
	}

	public void setAutobaujahr(Date autobaujahr) {
		this.autobaujahr = autobaujahr;
	}

	public String getAutomarke() {
		return this.automarke;
	}

	public void setAutomarke(String automarke) {
		this.automarke = automarke;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artikelgruppe getArtikelgruppe() {
		return this.artikelgruppe;
	}

	public void setArtikelgruppe(Artikelgruppe artikelgruppe) {
		this.artikelgruppe = artikelgruppe;
	}

}