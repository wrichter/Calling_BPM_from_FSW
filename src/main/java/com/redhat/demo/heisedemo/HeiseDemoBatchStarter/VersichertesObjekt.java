package com.redhat.demo.heisedemo.HeiseDemoBatchStarter;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class VersichertesObjekt extends java.lang.Object implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    @XmlElement
    private java.lang.String adresse1;
    @XmlElement
    private java.lang.String haustyp;
    @XmlElement
    private java.lang.String ort;
    @XmlElement
    private java.lang.Integer plz;
    @XmlElement
    private java.util.Date vertragsbeginn;
    @XmlElement
    private java.lang.Integer wohnflaeche;

    public VersichertesObjekt() {
    }

    public VersichertesObjekt(java.util.Date vertragsbeginn, java.lang.Integer wohnflaeche, java.lang.String haustyp, java.lang.String adresse1, java.lang.Integer plz, java.lang.String ort) {
        this.vertragsbeginn = vertragsbeginn;
        this.wohnflaeche = wohnflaeche;
        this.haustyp = haustyp;
        this.adresse1 = adresse1;
        this.plz = plz;
        this.ort = ort;
    }

    public java.lang.String getAdresse1() {
        return this.adresse1;
    }

    public void setAdresse1(java.lang.String adresse1) {
        this.adresse1 = adresse1;
    }

    public java.lang.String getHaustyp() {
        return this.haustyp;
    }

    public void setHaustyp(java.lang.String haustyp) {
        this.haustyp = haustyp;
    }

    public java.lang.String getOrt() {
        return this.ort;
    }

    public void setOrt(java.lang.String ort) {
        this.ort = ort;
    }

    public java.lang.Integer getPlz() {
        return this.plz;
    }

    public void setPlz(java.lang.Integer plz) {
        this.plz = plz;
    }

    public java.util.Date getVertragsbeginn() {
        return this.vertragsbeginn;
    }

    public void setVertragsbeginn(java.util.Date vertragsbeginn) {
        this.vertragsbeginn = vertragsbeginn;
    }

    public java.lang.Integer getWohnflaeche() {
        return this.wohnflaeche;
    }

    public void setWohnflaeche(java.lang.Integer wohnflaeche) {
        this.wohnflaeche = wohnflaeche;
    }
}