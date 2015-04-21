package com.anas.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the segment database table.
 * 
 */
@Entity
@Table(name="segment")
@NamedQuery(name="Segment.findAll", query="SELECT s FROM Segment s")
public class Segment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="s_id", unique=true, nullable=false)
	private int sId;

	@Column(length=20)
	private String name;

	//bi-directional many-to-one association to Ebene
	@OneToMany(mappedBy="segment")
	private Set<Ebene> ebenes;

	//bi-directional many-to-one association to Regal
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="r_id")
	private Regal regal;

	public Segment() {
	}

	public int getSId() {
		return this.sId;
	}

	public void setSId(int sId) {
		this.sId = sId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Ebene> getEbenes() {
		return this.ebenes;
	}

	public void setEbenes(Set<Ebene> ebenes) {
		this.ebenes = ebenes;
	}

	public Ebene addEbene(Ebene ebene) {
		getEbenes().add(ebene);
		ebene.setSegment(this);

		return ebene;
	}

	public Ebene removeEbene(Ebene ebene) {
		getEbenes().remove(ebene);
		ebene.setSegment(null);

		return ebene;
	}

	public Regal getRegal() {
		return this.regal;
	}

	public void setRegal(Regal regal) {
		this.regal = regal;
	}

}