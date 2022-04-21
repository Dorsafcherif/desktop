/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Formation;
import edu.esprit.entities.Participant;
import edu.esprit.services.FormationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class FormationAjoutController implements Initializable {

    @FXML
    private AnchorPane Fenetreajoutcourss;
    @FXML
    private TextField lieu;
    @FXML
    private Button FajouterCours;
    @FXML
    private TextField nb_participant;
    @FXML
    private TextField description;
    @FXML
    private Hyperlink ReturnAcceuil;
    @FXML
    private Hyperlink précedent;
    @FXML
    private Label aas;
    @FXML
    private Label imgpathttt;
    @FXML
    private ImageView imgajoutincours;
    @FXML
    private TextField type_form;
    @FXML
    private TextField libelle;
    @FXML
    private TextField prix;
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public boolean validateInputs() {
     if (date_debut.getValue().isBefore(date_fin.getValue())){
           Alert alert2 = new Alert(Alert.AlertType.WARNING);
                alert2.setTitle("Erreur !");
                alert2.setContentText("Date Fin doit etre superieur au date debut !");
                alert2.setHeaderText(null);
                alert2.show();
                return false;
     }
     else if (date_debut.getValue().isAfter(LocalDate.now())) {
          Alert alert2 = new Alert(Alert.AlertType.WARNING);
                alert2.setTitle("Erreur !");
                alert2.setContentText("Date debut doit etre egale ou superieur au date actuel!");
                alert2.setHeaderText(null);
                alert2.show();
                return false;
     }
     return false;
     }
       

    
    
      @FXML
    
    private void FajouterCours(ActionEvent event) throws SQLException, IOException {
          FormationService productService = new FormationService();
        
        if (libelle.getText().equals("")
                || description.getText().equals("")
                || type_form.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
            a.setHeaderText(null);
            a.showAndWait();
          
                }   else if (libelle.getText().matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")
                || description.getText().equals("")
                || type_form.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText(" Le champs entreprise ne doit pas contenir le symbole : ");
            a.setHeaderText(null);
            a.showAndWait();
        }       
   
               
               
         
       java.util.Date date2
                = java.util.Date.from(this.date_debut.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                 java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
                 
                   java.util.Date date3
                = java.util.Date.from(this.date_fin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                 java.sql.Date sqlDate3 = new java.sql.Date(date2.getTime());

                 
                    Formation c = new Formation(lieu.getText(),sqlDate2,type_form.getText(),
                
               libelle.getText(),Integer.parseInt(nb_participant.getText()),description.getText(),
                Integer.parseInt(prix.getText()),sqlDate3);
               
                
                
               productService.ajouterFormation(c);

       
            
       
      Parent page1 = FXMLLoader.load(getClass().getResource("OffreGestion.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Offres");
        stage.setScene(scene);
        stage.show();
        

              
                    
        
          }
    
    
    

  

    @FXML
    private void précedent(ActionEvent event) throws IOException {
         Parent page1 = FXMLLoader.load(getClass().getResource("FormationGestion.fxml"));
        Scene scene = new Scene(page1);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void ReturnAcceuilAjoutcours(ActionEvent event)
    {
        
    }
    
    @FXML
    private void logdansjoutcours(ActionEvent event)
    {
        
    }

  
    
}
