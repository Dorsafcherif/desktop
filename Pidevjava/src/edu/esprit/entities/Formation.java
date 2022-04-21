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
public class Formation {
    private int id ;
    private  String lieu ;
    private Date date_debut;
    private String type_form;
    private String libelle;
    private int nb_participant;
    private String description;
    private int prix; 
    
    private Date date_fin;
    
    private List<Participant> listparticipant;

    public Formation() {
    }

    public Formation(int id, String lieu, Date date_debut, String type_form, String libelle, int nb_participant, String description, int prix, Date date_fin, List<Participant> listparticipant) {
        this.id = id;
        this.lieu = lieu;
        this.date_debut = date_debut;
        this.type_form = type_form;
        this.libelle = libelle;
        this.nb_participant = nb_participant;
        this.description = description;
        this.prix = prix;
        this.date_fin = date_fin;
        this.listparticipant = listparticipant;
    }

    public Formation(String lieu, Date date_debut, String type_form, String libelle, int nb_participant, String description, int prix, Date date_fin, List<Participant> listparticipant) {
        this.lieu = lieu;
        this.date_debut = date_debut;
        this.type_form = type_form;
        this.libelle = libelle;
        this.nb_participant = nb_participant;
        this.description = description;
        this.prix = prix;
        this.date_fin = date_fin;
        this.listparticipant = listparticipant;
    }

    public Formation(int id, String lieu, Date date_debut, String type_form, String libelle, int nb_participant, String description, int prix, Date date_fin) {
        this.id = id;
        this.lieu = lieu;
        this.date_debut = date_debut;
        this.type_form = type_form;
        this.libelle = libelle;
        this.nb_participant = nb_participant;
        this.description = description;
        this.prix = prix;
        this.date_fin = date_fin;
    }

    public Formation(String lieu, Date date_debut, String type_form, String libelle, int nb_participant, String description, int prix, Date date_fin) {
        this.lieu = lieu;
        this.date_debut = date_debut;
        this.type_form = type_form;
        this.libelle = libelle;
        this.nb_participant = nb_participant;
        this.description = description;
        this.prix = prix;
        this.date_fin = date_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public String getType_form() {
        return type_form;
    }

    public void setType_form(String type_form) {
        this.type_form = type_form;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNb_participant() {
        return nb_participant;
    }

    public void setNb_participant(int nb_participant) {
        this.nb_participant = nb_participant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public List<Participant> getListparticipant() {
        return listparticipant;
    }

    public void setListparticipant(List<Participant> listparticipant) {
        this.listparticipant = listparticipant;
    }
    
    
    
    
    
}
