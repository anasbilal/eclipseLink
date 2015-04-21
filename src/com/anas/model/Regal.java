package com.anas.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the regal database table.
 * 
 */
@Entity
@Table(name="regal")
@NamedQuery(name="Regal.findAll", query="SELECT r FROM Regal r")
public class Regal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="r_id", unique=true, nullable=false)
	private int rId;

	@Column(length=20)
	private String name;

	//bi-directional many-to-one association to Segment
	@OneToMany(mappedBy="regal")
	private Set<Segment> segments;

	public Regal() {
	}

	public int getRId() {
		return this.rId;
	}

	public void setRId(int rId) {
		this.rId = rId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Segment> getSegments() {
		return this.segments;
	}

	public void setSegments(Set<Segment> segments) {
		this.segments = segments;
	}

	public Segment addSegment(Segment segment) {
		getSegments().add(segment);
		segment.setRegal(this);

		return segment;
	}

	public Segment removeSegment(Segment segment) {
		getSegments().remove(segment);
		segment.setRegal(null);

		return segment;
	}

}