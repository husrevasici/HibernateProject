package com.husrev.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Personel;

public class app {

	public static void main(String[] args) {
		Personel personel1 = new Personel();
		// personel1.setPersonelId(1);
		personel1.setPersonelAdi("Mehmet");
		personel1.setPersonelSoyadi("Yilmaz");
		personel1.setPersonelKayitTarihi(new Date());
		personel1.setPersonelAdresi("Ankara - Cankaya");
		personel1.setPersonelMaasi("5000");
		personel1.setPersonelTelefon("0535165161615");

		Personel personel2 = new Personel();
		personel2.setPersonelAdi("Veli");
		personel2.setPersonelSoyadi("Yilmaz");
		personel2.setPersonelKayitTarihi(new Date());
		personel2.setPersonelAdresi("Ankara - Cankaya");
		personel2.setPersonelMaasi("5000");
		personel2.setPersonelTelefon("0535165161615");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(personel1);
		session.save(personel2);
		session.getTransaction().commit();
		session.close();

		personel1 = null;
		session = sessionFactory.openSession();
		session.beginTransaction();

		for (int i = 1; i < 7; i++) {
			personel1 = session.get(Personel.class, i);
			System.out.println("ID DEGERI : " + personel1.getPersonelId());
			System.out.println("ADI SOYADI: " + personel1.getPersonelAdi() + personel1.getPersonelSoyadi());
			System.out.println("KAYIT TARIHI: " + personel1.getPersonelKayitTarihi());
			System.out.println("ADRESI: " + personel1.getPersonelAdresi());
			System.out.println("MAASI: " + personel1.getPersonelMaasi());
			System.out.println("TELEFON: " + personel1.getPersonelTelefon());
			System.out.println("**************************************************");
		}



		session.close();
	}

}
