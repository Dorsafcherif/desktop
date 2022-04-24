/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.DemandeFormateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyDB;

/**
 *
 * @author lenovo
 */
public class DemandeFormateurService implements DemandeService<DemandeFormateur> {
    
    Connection cnx;
    public DemandeFormateurService(){
    cnx=MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(DemandeFormateur t) {
        try {
            String req = "insert into demande_formateur(nom,prenom,adresse,mail,telephone,date_de_naissance,sexe,cv) Values(?,?,?,?,?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, t.getNom());
            st.setString(2, t.getPrenom());
            st.setString(3, t.getAdresse());
            st.setString(4, t.getMail());
            st.setInt(5, t.getTelephone());
            st.setDate(6, t.getDatedenaissance());
            st.setString(7, t.getSexe());
            st.setString(8, t.getCv());
            
           
            st.executeUpdate();
            System.out.println("demande ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifier(DemandeFormateur t) {
        try {
            String req= "update personne set nom= ?,prenom= ?,mail = ?,adresse = ?,telephone = ?,sexe = ? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);//+ sécurisée +rapide ,utilisee lors de lutilisation des requete dynnamique
            ps.setString(1, t.getNom());
            ps.setString(2, t.getPrenom());
            ps.setString(3, t.getAdresse());
            ps.setString(4, t.getMail());
            ps.setInt(5, t.getTelephone());
            ps.setString(6, t.getSexe());
            
            ps.setInt(7, t.getId());
            ps.executeUpdate();


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());     
                }
        
    }
    


    @Override
    public void supprimer(int id) {
      
            String rq="delete from demande_formateur where id=?";
    try{
        //creer un Prepared statement
        PreparedStatement pst=cnx.prepareStatement(rq);

        pst.setInt(1,id);
        pst.executeUpdate();
        System.out.println("demande supprimée");
            }catch (SQLException ex) {
        System.out.println("demande non suprrimé");

    }    
    }



    @Override
    public List<DemandeFormateur> GetAll() {
 List<DemandeFormateur> list = new ArrayList<>();
        try {
            String request = "SELECT * FROM demande_formateur";
            PreparedStatement st = cnx.prepareStatement(request);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new DemandeFormateur( rs.getString("nom"), rs.getString("prenom"),rs.getString("adresse"), rs.getString("mail"),rs.getString("sexe"),rs.getString("cv"),rs.getInt("id"), rs.getInt("telephone"),rs.getDate("date_de_naissance")));
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public DemandeFormateur GetById(int id) {
        return GetAll().stream().filter(e -> e.getId() == id).findFirst().get();
    }
}

  

    

   
