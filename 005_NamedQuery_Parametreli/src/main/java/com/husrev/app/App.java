package com.husrev.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.husrev.model.Ogrenci;

public class App {

	static EntityManagerFactory emf;
	static EntityManager em;

	public static void main(String[] args) {

		Ogrenci ogrenci = new Ogrenci();
//		 ogrenci.setId(1);
		ogrenci.setAdi("Suleyman");
		ogrenci.setSoyadi("Aytas");
		ogrenci.setBolum("Endustri");
		ogrenci.setFakulte("Muhendislik");
		ogrenci.setNo("888888888");

		Ogrenci ogrenci1 = new Ogrenci("Ahmet", "Makine", "Muhendislik", "123", "Yılmaz");
		Ogrenci ogrenci2 = new Ogrenci("Mehmet", "Kimya", "Muhendislik", "345", "Yılmaz");

		emf = Persistence.createEntityManagerFactory("PU_AyarDosyasi_005"); // persistence-unit adi
		em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		try {

			et.begin();
			em.persist(ogrenci1);
			em.persist(ogrenci2);
//			kayitEkle(em, "Berrak", "Degirmenci", "123", "Edebiyat", "Fen Fakultesi");
			et.commit();

		} catch (Exception e) {
			et.rollback();
		} finally {
			if (em != null) {
				kayitlariYazHepsi();
				kayitlariYazSecilen();

				em.close();
				emf.close();
			}
		}

	}

	private static void kayitlariYazSecilen() {

		int gelendeger = 3;
		String gelenAdi = "Husrevv";
		Query query = em.createNamedQuery("ogrenci.AdiSoyadiSorgula").setParameter("p_id", gelendeger)
				.setParameter("p_adi", gelenAdi);
		List<?> list = query.getResultList();

		for (Object obj : list) {
			Ogrenci ogrenci = (Ogrenci) obj;

			System.out.println("\nID : " + ogrenci.getId() + "\nADI SOYADI: " + ogrenci.getAdi() + " "
					+ ogrenci.getSoyadi() + "\nFAKÜLTE : " + ogrenci.getFakulte() + "\nBÖLÜMÜ : " + ogrenci.getBolum());
		}

	}

	private static void kayitlariYazHepsi() {

		Query query = em.createNamedQuery("Ogrenci.findAll");
		List<?> list = query.getResultList();

		for (Object obj : list) {
			Ogrenci ogrenci = (Ogrenci) obj;

			System.out.println("\nID : " + ogrenci.getId() + "\nADI SOYADI: " + ogrenci.getAdi() + " "
					+ ogrenci.getSoyadi() + "\nFAKÜLTE : " + ogrenci.getFakulte() + "\nBÖLÜMÜ : " + ogrenci.getBolum());
		}

	}

	public static void kayitEkle(EntityManager em, String adi, String soyadi, String no, String bolum, String fakulte) {

		Ogrenci ogrenciNesnesi = new Ogrenci(adi, bolum, fakulte, no, soyadi);

		em.persist(ogrenciNesnesi);

	}

}