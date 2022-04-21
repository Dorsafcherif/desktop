/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Formation;
import edu.esprit.entities.Participant;
import edu.esprit.services.FormationService;
import edu.esprit.services.ParticipantService;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class ParticipantGestionController implements Initializable {

    @FXML
    private TableView<Participant> tableview;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> prenom;
    @FXML
    private TableColumn<?, ?> adresse;
    @FXML
    private TableColumn<?, ?> date_naissance;
    @FXML
    private Button supp;
    @FXML
    private Button modif;
    @FXML
    private Button Ajouter;
    @FXML
    private Label imgpathttt;
    @FXML
    private Label labelid;
    @FXML
    private TextField inputRech;
   
 public ObservableList<Participant> list;
    @FXML
    private TextField nom2;
    @FXML
    private TextField prenom2;
    @FXML
    private TextField adresse2;
    @FXML
    private DatePicker date_naissance2;
    @FXML
    private Button Confirmer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ParticipantService pss = new ParticipantService();
        ArrayList<Participant> c = new ArrayList<>();
        try {
            c = (ArrayList<Participant>) pss.AfficherParticipant();
        } catch (SQLException ex) {
        }
        
        ObservableList<Participant> obs2 = FXCollections.observableArrayList(c);
        tableview.setItems(obs2);
        
        
           
        
        
 nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        date_naissance.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
    
            try {
            list = FXCollections.observableArrayList(
                    pss.AfficherParticipant()
            );        
        
        
   FilteredList<Participant> filteredData = new FilteredList<>(list, e -> true);
            inputRech.setOnKeyReleased(e -> {
                inputRech.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super Participant>) Participants -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        if (Participants.getNom().toLowerCase().contains(lower)) {
                            return true;
                        }

                        return false;
                    });
                });
                SortedList<Participant> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
  public void resetTableData() throws SQLDataException, SQLException {
      ParticipantService cs = new ParticipantService();
      List<Participant> listevents = new ArrayList<>();
        listevents = cs.AfficherParticipant();
        ObservableList<Participant> data = FXCollections.observableArrayList(listevents);
        tableview.setItems(data);
    }  
  
  
  
    @FXML
    private void supp(ActionEvent event) throws SQLException {
            if (event.getSource() == supp) {
            Participant e = new Participant();
            e.setId(tableview.getSelectionModel().getSelectedItem().getId());  
          ParticipantService cs = new ParticipantService();
            cs.SupprimerParticipant(e);
            resetTableData();  
        
        }
        
        
        
        
        
    }

    @FXML
    private void Modif(ActionEvent event) {
        ParticipantService ps = new ParticipantService();
          
   
                Participant c = new Participant(tableview.getSelectionModel().getSelectedItem().getId(),
                tableview.getSelectionModel().getSelectedItem().getNom(),
               tableview.getSelectionModel().getSelectedItem().getPrenom(),
                 tableview.getSelectionModel().getSelectedItem().getAdresse(),
                tableview.getSelectionModel().getSelectedItem().getDate_naissance()  
                );
        
           
            labelid.setText(Integer.toString(tableview.getSelectionModel().getSelectedItem().getId()));
         
            nom2.setText(tableview.getSelectionModel().getSelectedItem().getNom());
            
            prenom2.setText(tableview.getSelectionModel().getSelectedItem().getPrenom());
            adresse2.setText(tableview.getSelectionModel().getSelectedItem().getAdresse());

           java.sql.Date r;
        r = new java.sql.Date(tableview.getSelectionModel().getSelectedItem().getDate_naissance().getTime());
        LocalDate date = r.toLocalDate();

date_naissance2.setValue(  date);
         
           Confirmer.setVisible(true);    
        
        
    }

    @FXML
    private void Ajouter(ActionEvent event) throws SQLException, IOException {
           ParticipantService productService = new ParticipantService();
  
        if (nom2.getText().equals("")
                || prenom2.getText().equals("") 
                || adresse2.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
            a.setHeaderText(null);
            a.showAndWait();
        } else if (nom2.getText().equals("")
                || prenom2.getText().equals("") || adresse2.getText().matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")
               ) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Une erreur s’est produite. Veuillez réessayer. ");
            a.setHeaderText(null);
            a.showAndWait();
        }
    java.util.Date date2
                = java.util.Date.from(this.date_naissance2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                 java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
                 
             
       
            
        
            Participant c = new Participant(nom2.getText(),
                    
                  prenom2.getText(), adresse2.getText(),sqlDate2
                          );
        
              
            productService.ajouterParticipant(c);
       
        
          
             
        
     
     
        
        
    }

    @FXML
    private void Confirmer(ActionEvent event) throws NoSuchAlgorithmException {
           ParticipantService productService = new ParticipantService();
  
        if (nom2.getText().equals("")
                || prenom2.getText().equals("") 
                || adresse2.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Please fill all fields ");
            a.setHeaderText(null);
            a.showAndWait();
        } else if (nom2.getText().equals("")
                || prenom2.getText().equals("") || adresse2.getText().matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")
               ) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Une erreur s’est produite. Veuillez réessayer. ");
            a.setHeaderText(null);
            a.showAndWait();
        }
    
            
        java.util.Date date2
                = java.util.Date.from(this.date_naissance2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                 java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
            
        
            Participant c = new Participant(Integer.parseInt(labelid.getText()),nom2.getText(),
                    
                  prenom2.getText(), adresse2.getText(),sqlDate2
                          );
        
                try {
            productService.modifierParticipant(c);
             resetTableData();
        } catch (SQLException ex) {
        }
        
     ;
        
        
        
    }


  
    
}
