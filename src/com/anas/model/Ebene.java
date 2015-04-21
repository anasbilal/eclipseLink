package com.anas.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ebene database table.
 * 
 */
@Entity
@Table(name="ebene")
@NamedQuery(name="Ebene.findAll", query="SELECT e FROM Ebene e")
public class Ebene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="e_id", unique=true, nullable=false)
	private int eId;

	//bi-directional many-to-one association to Segment
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="s_id")
	private Segment segment;

	public Ebene() {
	}

	public int getEId() {
		return this.eId;
	}

	public void setEId(int eId) {
		this.eId = eId;
	}

	public Segment getSegment() {
		return this.segment;
	}

	public void setSegment(Segment segment) {
		this.segment = segment;
	}

}