/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class Participant {
    private int id ;
    private String nom;
    private String prenom;
    private String adresse;
    private Date date_naissance;
private List<Formation> listformation;    

    public Participant() {
    }

    public Participant(int id, String nom, String prenom, String adresse, Date date_naissance, List<Formation> listformation) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.date_naissance = date_naissance;
        this.listformation = listformation;
    }

    public Participant(String nom, String prenom, String adresse, Date date_naissance, List<Formation> listformation) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.date_naissance = date_naissance;
        this.listformation = listformation;
    }

    public Participant(int id, String nom, String prenom, String adresse, Date date_naissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.date_naissance = date_naissance;
    }

    public Participant(String nom, String prenom, String adresse, Date date_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.date_naissance = date_naissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public List<Formation> getListformation() {
        return listformation;
    }

    public void setListformation(List<Formation> listformation) {
        this.listformation = listformation;
    }
    
    
}
