/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Formation;
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
public class FormationService {
  Connection connexion;   
  public FormationService() {
        connexion = Connexion.getInstance().getCnx();
    }
 

 /* //@Override
  public void ajouterFormation(Formation e) throws SQLException {
        String req = "INSERT INTO `formation` (`lieu`,`date_debut`,`type_form`,`libelle`,`nb_participant`,`description`,`prix`,`date_fin`) "
                + "VALUES (?,?,?,?,?,?,?,?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setString(1, e.getLieu());
        ps.setDate(2,(java.sql.Date) (Date) e.getDate_debut());
        ps.setString(3,  e.getType_form());
        ps.setString(4, e.getLibelle());
        ps.setInt(5, e.getNb_participant());
        ps.setString(6, e.getDescription());
        ps.setInt(7, e.getPrix());
     //   ps.setDate(8, (java.sql.Date) (Date) e.getDate_fin());      
        ps.executeUpdate();
    }
  
  */
    public void ajouterFormation(Formation e) {
           

        String req = "INSERT INTO `formation` (`lieu`,`date_debut`,`type_form`,`libelle`,`nb_participant`,`description`,`prix`,`date_fin`) "
                + "VALUES (?,?,?,?,?,?,?,?) ";
        try{
      PreparedStatement ps = connexion.prepareStatement(req); //preparestatement :securisé , requet dynamique (passer des paremetres) insertion , supression 
         ps.setString(1, e.getLieu());
        ps.setDate(2,(java.sql.Date) (Date) e.getDate_debut());
        ps.setString(3,  e.getType_form());
        ps.setString(4, e.getLibelle());
        ps.setInt(5, e.getNb_participant());
        ps.setString(6, e.getDescription());
        ps.setInt(7, e.getPrix());
        ps.setDate(8, (java.sql.Date)(Date) e.getDate_fin());    
        ps.executeUpdate();}
        catch(SQLException d){
                System.out.println(d.getMessage());
        }
    }

     public List<Formation> AfficherFormation() throws SQLException {
        List<Formation> Formations = new ArrayList<>();
        String req = "select * from formation ";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Formation e = new Formation(rst.getInt("id")
                    , rst.getString("lieu")
                    , rst.getDate("date_debut")
                    , rst.getString("type_form")
                    , rst.getString("libelle")
                     , rst.getInt("nb_participant")
                     , rst.getString("description")
                     , rst.getInt("prix")
                     , rst.getDate("date_fin")
            
            
            );
            Formations.add(e);
        }
        return Formations;
    }
     
     
             
         
   

     public void SupprimerFormation(Formation e) throws SQLException {

        String req = "DELETE FROM formation WHERE id =?";
        try {
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

   
 
      public void modifierFormation(Formation e) throws SQLException, NoSuchAlgorithmException {
        String req = "UPDATE formation SET "
                + " lieu='"+e.getLieu()+"'"
                + ", date_debut='"+e.getDate_debut()+"'"
                + ", type_form='"+e.getType_form()+"'"
                + ", libelle='"+e.getLibelle()+"'"
                + ", nb_participant='"+e.getNb_participant()+"'"
                + ", description='"+e.getDescription()+"'"
                + ", prix  ='"+ e.getPrix()+"'"
                
                + ", date_fin='"+ (java.sql.Date) (Date)e.getDate_fin()+"' where id  = "+e.getId()+"";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    } 
      
      
      
      
      
      
      
      
}
