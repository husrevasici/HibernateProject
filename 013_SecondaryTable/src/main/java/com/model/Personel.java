package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CALISANLAR") // table ozellikleri
@SecondaryTable(name = "PersonelDetay") // ikinci tablo
public class Personel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personelId;
	private String personelAdi;
	private String personelSoyadi;

	@Temporal(TemporalType.DATE)

	@Column(name = "tarih", table = "PersonelDetay") // hem ismini baska tabloya aldik.
	private Date personelKayitTarihi;

	@Column(name = "Adres", table = "PersonelDetay") // hem ismini baska tabloya aldik.
	private String personelAdresi;

	@Column(name = "Maas", table = "PersonelDetay") // hem ismini baska tabloya aldik.
	private String personelMaasi;

	@Column(name = "Telefon", table = "PersonelDetay") // hem ismini baska tabloya aldik.
	private String personelTelefon;

	public String getPersonelMaasi() {
		return personelMaasi;
	}

	public void setPersonelMaasi(String personelMaasi) {
		this.personelMaasi = personelMaasi;
	}

	public String getPersonelTelefon() {
		return personelTelefon;
	}

	public void setPersonelTelefon(String personelTelefon) {
		this.personelTelefon = personelTelefon;
	}

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
