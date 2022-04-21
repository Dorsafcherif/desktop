/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Participant;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class AfficherDetailFormationController implements Initializable {

    @FXML
    private ListView<?> listview;
    @FXML
    private Label libelle;
    @FXML
    private Label prix;
    @FXML
    private Label description;
    @FXML
    private Label type_form;
    @FXML
    private Label nb_participant;
    @FXML
    private Label date_debut;
    @FXML
    private Label date_fin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
         

         type_form.setText(FormationGestionController.connectedFormaion2.getType_form());
         
         
        libelle.setText( FormationGestionController.connectedFormaion2.getLibelle());
             nb_participant.setText( Integer.toString(FormationGestionController.connectedFormaion2.getNb_participant()));
             
             prix.setText(Integer.toString(FormationGestionController.connectedFormaion2.getPrix()));
             
             description.setText( FormationGestionController.connectedFormaion2.getDescription());
             
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           String strDate = dateFormat.format( FormationGestionController.connectedFormaion2.getDate_debut());   
             String strDate2 = dateFormat.format( FormationGestionController.connectedFormaion2.getDate_fin());
            date_debut.setText(strDate);
    date_fin.setText(strDate2);
             
             

    
//               for(Participant r : FormationGestionController.connectedFormaion2.getListparticipant()){
//                       // DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//
//           
//            //listview.getItems().add(r.getNom());
//        }
        
        
        
      
    }    
    
}
