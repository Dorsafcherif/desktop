/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author lenovo
 */
public class DemandeFormateur {
   private String nom,prenom,adresse,mail,sexe,cv;
   private int id,telephone;
  private Date datedenaissance;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Date getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(Date datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    @Override
    public String toString() {
        return "DemandeFormateur{" + "nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", mail=" + mail + ", sexe=" + sexe + ", cv=" + cv + ", id=" + id + ", telephone=" + telephone + ", datedenaissance=" + datedenaissance + '}';
    }

    public DemandeFormateur(String nom, String prenom, String adresse, String mail, String sexe, String cv, int telephone, Date datedenaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.sexe = sexe;
        this.cv = cv;
        this.telephone = telephone;
        this.datedenaissance = datedenaissance;
    }

    public DemandeFormateur(String nom, String prenom, String adresse, String mail, String sexe, String cv, int telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.sexe = sexe;
        this.cv = cv;
        this.telephone = telephone;
    }

    public DemandeFormateur() {
    }

   

    public DemandeFormateur(String nom, String prenom, String adresse, String mail, String sexe, String cv, int id, int telephone, Date datedenaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.sexe = sexe;
        this.cv = cv;
        this.id = id;
        this.telephone = telephone;
        this.datedenaissance = datedenaissance;
    }
}
 