package com.anas.junittest;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.anas.model.Artikelgruppe;

public class JunitDemotest {
	static EntityManager em;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Reverse");
		em = emf.createEntityManager();
	}

	@Test
	public void test() {
		Artikelgruppe artgr = new Artikelgruppe();
		artgr.setName("AAA");
		em.persist(artgr);
		assertNotNull(artgr);
		assertTrue(artgr.getName()=="AAA");
	}
	
	@Test
	public void findAll(){
		List<Artikelgruppe> artgrliste = em.createNamedQuery("Artikelgruppe.findAll")
				.getResultList();
		assertTrue(artgrliste.size() > 0);
		
	}
	
	@Test
	public void removeEntity(){
		em.getTransaction().begin();
		Artikelgruppe a = em.find(Artikelgruppe.class,33);
		System.out.println(a.getName()+" "+a.getArtgruppeId());
		em.remove(a);
		em.getTransaction().commit();
		List<Artikelgruppe> artgrliste = em.createNamedQuery("Artikelgruppe.findAll")
				.getResultList();
		System.out.println(artgrliste.size());
		
		assertFalse(artgrliste.contains(a));
	}

}
