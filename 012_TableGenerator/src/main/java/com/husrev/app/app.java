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
		personel1.setPersonelAdi("Husrev");
		personel1.setPersonelSoyadi("Asici");
		personel1.setPersonelKayitTarihi(new Date());
		personel1.setPersonelAdresi("Adana");

		Personel personel2 = new Personel();
		// personel1.setPersonelId(1);
		personel2.setPersonelAdi("Suleyman");
		personel2.setPersonelSoyadi("Cicek");
		personel2.setPersonelKayitTarihi(new Date());
		personel2.setPersonelAdresi("Mersin");

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
		personel1 = session.get(Personel.class, 1);
		System.out.println("ID DEGERI : " + personel1.getPersonelId());
		System.out.println("ADI SOYADI: " + personel1.getPersonelAdi() + personel1.getPersonelSoyadi());
		System.out.println("KAYIT TARIHI: " + personel1.getPersonelKayitTarihi());
		System.out.println("ADRESI: " + personel1.getPersonelAdresi());

		System.out.println("**************************************************");

		personel2 = session.get(Personel.class, 2);
		System.out.println("ID DEGERI : " + personel2.getPersonelId());
		System.out.println("ADI SOYADI: " + personel2.getPersonelAdi() + personel2.getPersonelSoyadi());
		System.out.println("KAYIT TARIHI: " + personel2.getPersonelKayitTarihi());
		System.out.println("ADRESI: " + personel2.getPersonelAdresi());

		session.close();
	}

}
