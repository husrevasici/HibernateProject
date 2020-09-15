package com.husrev.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;

@Entity
@Table(name = "CALISANLAR") // Tablo name
public class Personel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int personelId;	
	private String personelAdi;
	private String personelSoyadi;
	
	@Temporal (TemporalType.DATE) // Tarih: 2013-11-05 23:44:19 ise --> sadece tarih kismini alacaktir. Saat kismini dikkate almaz.
	private Date personelKayitTarihi;
	
	@Lob // large obje -- genis veri alani turudur. 
	private String personelAdresi;

	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

	// ----------------------------------------------------------

	public String getPersonelAdi() {
		return personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}

	// ----------------------------------------------------------

	public String getPersonelSoyadi() {
		return personelSoyadi;
	}

	public void setPersonelSoyadi(String personelSoyadi) {
		this.personelSoyadi = personelSoyadi;
	}

	// ----------------------------------------------------------

	public Date getPersonelKayitTarihi() {
		return personelKayitTarihi;
	}

	public void setPersonelKayitTarihi(Date personelKayitTarihi) {
		this.personelKayitTarihi = personelKayitTarihi;
	}

	// ----------------------------------------------------------

	public String getPersonelAdresi() {
		return personelAdresi;
	}

	public void setPersonelAdresi(String personelAdresi) {
		this.personelAdresi = personelAdresi;
	}

}
