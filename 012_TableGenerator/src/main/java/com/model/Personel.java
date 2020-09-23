package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CALISANLAR")
public class Personel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "ektablo", table = "tblpersonel", pkColumnName = "ID",
	pkColumnValue = "SonrakiIDDegeri", allocationSize = 1) // Ek tablo olusturmaya yarar.
	
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ektablo")
	// Ek tablo mevcut ise strategy = GenerationType.TABLE secilmelidir.

	// @TableGenerator eklediğimde "GenerationTarget encountered exception accepting
	// command : Error executing DDL "create table"
	// hatasini aldim. Cozum ise hibernate.cfg.xml dosyasındaki
	// <property
	// name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
	// satirini eklemek.
	// MySQL5Dialect -> MySQL8Dialect olarak degistirmek.

	private int personelId;
	private String personelAdi;
	private String personelSoyadi;

	@Temporal(TemporalType.DATE)
	private Date personelKayitTarihi;

	@Lob
	private String personelAdresi;

	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

	public String getPersonelAdi() {
		return personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}

	public String getPersonelSoyadi() {
		return personelSoyadi;
	}

	public void setPersonelSoyadi(String personelSoyadi) {
		this.personelSoyadi = personelSoyadi;
	}

	public Date getPersonelKayitTarihi() {
		return personelKayitTarihi;
	}

	public void setPersonelKayitTarihi(Date personelKayitTarihi) {
		this.personelKayitTarihi = personelKayitTarihi;
	}

	public String getPersonelAdresi() {
		return personelAdresi;
	}

	public void setPersonelAdresi(String personelAdresi) {
		this.personelAdresi = personelAdresi;
	}
}
