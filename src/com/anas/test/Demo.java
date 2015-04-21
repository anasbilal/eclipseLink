package com.anas.test;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anas.model.Artikel;
import com.anas.model.Artikelgruppe;
import com.anas.utils.Util;

public class Demo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Reverse");
		EntityManager em = emf.createEntityManager();
		List<Artikelgruppe> artgrliste = null;
		Artikel art = null;
		Artikelgruppe artgr = null;
		try {
			artgr = new Artikelgruppe();
			artgr.setName("GruppeC");
			art = new Artikel();
			art.setName("ArtikelA");
			//SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
			//String dateInString = "31-08-1982";
			//Date date = sdf.parse(dateInString);
			//Util.parsedatum("31-08-1982");
			art.setArtikelbaujahr(Util.parsedatum("1982-08-31"));
			//dateInString = "2012-11-11";
			//date = sdf.parse(dateInString);
			art.setAutobaujahr(Util.parsedatum("2012-11-11"));
			art.setAutomarke("VW");
			art.setArtikelgruppe(artgr);
			System.out.println(art.getName()+"\t"+art.getArtikelgruppe());
			artgr.getArtikels().add(art);
			//++++++++++++++++++++++++++++++
			
			art = new Artikel();
			art.setName("ArtikelB");
			//dateInString = "2010-10-10";
			//date = sdf.parse(dateInString);
			art.setArtikelbaujahr(Util.parsedatum("2010-10-10"));
			//dateInString = "2011-11-11";
			//date = sdf.parse(dateInString);
			art.setAutobaujahr(Util.parsedatum("2011-11-11"));
			art.setAutomarke("Mercedes");
			art.setArtikelgruppe(artgr);
			artgr.getArtikels().add(art);
			//++++++++++++++++++++++++++++++
			art = new Artikel();
			art.setName("ArtikelC");
			//dateInString = "2009-11-10";
			//date = sdf.parse(dateInString);
			art.setArtikelbaujahr(Util.parsedatum("2009-11-10"));
			//dateInString = "2007-11-11";
			//date = sdf.parse(dateInString);
			art.setAutobaujahr(Util.parsedatum("2007-11-11"));
			art.setAutomarke("Audi");
			art.setArtikelgruppe(artgr);
			artgr.getArtikels().add(art);
			//++++++++++++++++++++++++++++++

			em.getTransaction().begin();
			for (Artikel a : artgr.getArtikels()){
				System.out.println("Name: "+a.getName());
				em.persist(a);
			}
			em.persist(artgr);
			em.getTransaction().commit();

			artgrliste = em.createNamedQuery("Artikelgruppe.findAll")
					.getResultList();
			for (Artikelgruppe c : artgrliste){
				
				System.out.println(c.getName());
				for(Artikel a : c.getArtikels()){
					System.out.println(a.getName()+"\n"+a.getAutomarke()+
							"\n"+a.getArtikelbaujahr()+"\n"+a.getAutobaujahr());
				}
			}
			//em.createNativeQuery("Artikelgruppe.delete").setParameter("name", "GruppeC");
			em.getTransaction().begin();
			Artikelgruppe a = em.find(Artikelgruppe.class,31);
			em.remove(a);
			/*String query="SELECT a FROM Artikelgruppe a WHERE a.name = ?";
			List res = em.createNativeQuery(query).setParameter(1, "GruppeC").getResultList();
			System.out.println(res.size()+" Datensaetze wurden gefunden");*/
			em.getTransaction().commit();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}
}