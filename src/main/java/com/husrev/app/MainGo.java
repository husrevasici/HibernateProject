package com.husrev.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.husrev.model.Personel;

public class MainGo {

	public static void main(String[] args) {

		Personel personel = new Personel();

		personel.setPersonelId(1);
		personel.setPersonelAdi("Murat");
		personel.setPersonelSoyadi("Aslan");
		personel.setPersonelKayitTarihi(new Date());
		personel.setPersonelAdresi("Çankaya / ANKARA");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(personel);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		personel = session.get(Personel.class, 1);
		System.out.println("ID DEGERI : "+personel.getPersonelId());
		System.out.println("ADI SOYADI: "+personel.getPersonelAdi()+personel.getPersonelSoyadi());
		System.out.println("KAYIT TARIHI: "+personel.getPersonelKayitTarihi());
		System.out.println("ADRESI: "+personel.getPersonelAdresi());
		
		session.close();
	}
}
