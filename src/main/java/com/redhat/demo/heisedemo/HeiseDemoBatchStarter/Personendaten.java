package com.redhat.demo.heisedemo.HeiseDemoBatchStarter;


import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
public class Personendaten implements java.io.Serializable {

	static final long serialVersionUID = 1L;

		@XmlElement
	    private java.lang.String adresse1;
		@XmlElement
	    private java.lang.String bic;
		@XmlElement
	    private java.lang.String email;
		@XmlElement
	    private java.util.Date geburtsdatum;
		@XmlElement
	    private java.lang.String iban;
		@XmlElement
	    private java.lang.String nachname;
		@XmlElement
	    private java.lang.String ort;
		@XmlElement
	    private java.lang.Integer plz;
		@XmlElement
	    private java.lang.String rolle;
		@XmlElement
	    private java.lang.String telefon;
		@XmlElement
	    private java.lang.String vorname;

	    public Personendaten() {
	    }

	    public Personendaten(java.lang.String rolle, java.lang.String vorname, java.lang.String nachname, java.util.Date geburtsdatum, java.lang.String email, java.lang.String adresse1, java.lang.Integer plz, java.lang.String ort, java.lang.String iban, java.lang.String bic, java.lang.String telefon) {
	        this.rolle = rolle;
	        this.vorname = vorname;
	        this.nachname = nachname;
	        this.geburtsdatum = geburtsdatum;
	        this.email = email;
	        this.adresse1 = adresse1;
	        this.plz = plz;
	        this.ort = ort;
	        this.iban = iban;
	        this.bic = bic;
	        this.telefon = telefon;
	    }

		public java.lang.String getAdresse1() {
			return adresse1;
		}

		public void setAdresse1(java.lang.String adresse1) {
			this.adresse1 = adresse1;
		}

		public java.lang.String getBic() {
			return bic;
		}

		public void setBic(java.lang.String bic) {
			this.bic = bic;
		}

		public java.lang.String getEmail() {
			return email;
		}

		public void setEmail(java.lang.String email) {
			this.email = email;
		}

		public java.util.Date getGeburtsdatum() {
			return geburtsdatum;
		}

		public void setGeburtsdatum(java.util.Date geburtsdatum) {
			this.geburtsdatum = geburtsdatum;
		}

		public java.lang.String getIban() {
			return iban;
		}

		public void setIban(java.lang.String iban) {
			this.iban = iban;
		}

		public java.lang.String getNachname() {
			return nachname;
		}

		public void setNachname(java.lang.String nachname) {
			this.nachname = nachname;
		}

		public java.lang.String getOrt() {
			return ort;
		}

		public void setOrt(java.lang.String ort) {
			this.ort = ort;
		}

		public java.lang.Integer getPlz() {
			return plz;
		}

		public void setPlz(java.lang.Integer plz) {
			this.plz = plz;
		}

		public java.lang.String getRolle() {
			return rolle;
		}

		public void setRolle(java.lang.String rolle) {
			this.rolle = rolle;
		}

		public java.lang.String getTelefon() {
			return telefon;
		}

		public void setTelefon(java.lang.String telefon) {
			this.telefon = telefon;
		}

		public java.lang.String getVorname() {
			return vorname;
		}

		public void setVorname(java.lang.String vorname) {
			this.vorname = vorname;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
   }