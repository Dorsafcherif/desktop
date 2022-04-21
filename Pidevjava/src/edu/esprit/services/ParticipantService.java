/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Formation;
import edu.esprit.entities.Participant;
import edu.esprit.tools.Connexion;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class ParticipantService {
     Connection connexion;   
  public ParticipantService() {
        connexion = Connexion.getInstance().getCnx();
    }
 

  //@Override
  public void ajouterParticipant(Participant e) throws SQLException {
        String req = "INSERT INTO `participant` (`nom`,`prenom`,`adresse`,`date_naissance`) "
                + "VALUES (?,?,?,?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setString(1, e.getNom());
        ps.setString(2,  e.getPrenom());
       
        
        ps.setString(3, e.getAdresse());
         ps.setDate(4,(java.sql.Date) (Date) e.getDate_naissance());
        
        ps.executeUpdate();
    }

     public List<Participant> AfficherParticipant() throws SQLException {
        List<Participant> Participants = new ArrayList<>();
        String req = "select * from participant ";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Participant e = new Participant(rst.getInt("id")
                    , rst.getString("nom")
                    , rst.getString("prenom")
                    , rst.getString("adresse")
                    , rst.getDate("date_naissance")
                    
            
            );
            Participants.add(e);
        }
        return Participants;
    }
         public List<Participant> getPartic() throws SQLException {
        List<Participant> Participants = new ArrayList<>();
        String req = "select * from participant ";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Participant e = new Participant(rst.getInt("id")
                    , rst.getString("nom")
                    , rst.getString("prenom")
                    , rst.getString("adresse")
                    , rst.getDate("date_naissance")
                    
            
            );
            Participants.add(e);
        }
        return Participants;
    }
     
             
         
   

     public void SupprimerParticipant(Participant e) throws SQLException {

        String req = "DELETE FROM participant WHERE id =?";
        try {
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

   
 
      public void modifierParticipant(Participant e) throws SQLException, NoSuchAlgorithmException {
        String req = "UPDATE participant SET "
                + " nom='"+e.getNom()+"'"
               + ", prenom  ='"+ e.getPrenom()+"'"
                + ", adresse  ='"+ e.getAdresse()+"'"
                
                + ", date_naissance='"+ (java.sql.Date) (Date)e.getDate_naissance()+"' where id  = "+e.getId()+"";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    }  
}
