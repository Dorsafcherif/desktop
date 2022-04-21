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
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
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
public class FormationGestionController implements Initializable {
 public static Formation connectedFormaion;
  public static Formation connectedFormaion2;
    @FXML
    private TableView<Formation> tableview;
    @FXML
    private TableColumn<?, ?> lieu;
    @FXML
    private TableColumn<?, ?> date_debut;
    @FXML
    private TableColumn<?, ?> type_form;
    @FXML
    private TableColumn<?, ?> libelle;
    @FXML
    private TableColumn<?, ?> nb_participant;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private TableColumn<?, ?> prix;
    @FXML
    private TableColumn<?, ?> date_fin;
    @FXML
    private Button supp;
    @FXML
    private Button modif;
    @FXML
    private Button Ajouter;
    @FXML
    private Label imgpathttt;
    @FXML
    private Button affichsalle;
    @FXML
    private Label labelid;
    @FXML
    private TextField inputRech;
    @FXML
    private Hyperlink Retour;
 public ObservableList<Formation> list;
    @FXML
    private Hyperlink participant;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         FormationService pss = new FormationService();
        ArrayList<Formation> c = new ArrayList<>();
        try {
            c = (ArrayList<Formation>) pss.AfficherFormation();
        } catch (SQLException ex) {
        }
        
        ObservableList<Formation> obs2 = FXCollections.observableArrayList(c);
        tableview.setItems(obs2);
        
        
           
        
        
 lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        type_form.setCellValueFactory(new PropertyValueFactory<>("type_form"));
        libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
         nb_participant.setCellValueFactory(new PropertyValueFactory<>("nb_participant"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
    prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
    date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
   
            try {
            list = FXCollections.observableArrayList(
                    pss.AfficherFormation()
            );        
        
        
   FilteredList<Formation> filteredData = new FilteredList<>(list, e -> true);
            inputRech.setOnKeyReleased(e -> {
                inputRech.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super Formation>) Formations -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        if (Formations.getDescription().toLowerCase().contains(lower)) {
                            return true;
                        }

                        return false;
                    });
                });
                SortedList<Formation> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
  public void resetTableData() throws SQLDataException, SQLException {
      FormationService cs = new FormationService();
      List<Formation> listevents = new ArrayList<>();
        listevents = cs.AfficherFormation();
        ObservableList<Formation> data = FXCollections.observableArrayList(listevents);
        tableview.setItems(data);
    }   
    @FXML
    private void supp(ActionEvent event) throws SQLException {
              if (event.getSource() == supp) {
            Formation e = new Formation();
            e.setId(tableview.getSelectionModel().getSelectedItem().getId());  
          FormationService cs = new FormationService();
            cs.SupprimerFormation(e);
            resetTableData();  
        
        }
        
    }

    @FXML
    private void Modif(ActionEvent event) throws IOException {
         
        FormationService ps = new FormationService();
        
                Formation c =new Formation(
                        tableview.getSelectionModel().getSelectedItem().getId(),
                tableview.getSelectionModel().getSelectedItem().getLieu(),
                
                tableview.getSelectionModel().getSelectedItem().getDate_debut(),
                 tableview.getSelectionModel().getSelectedItem().getType_form(),
                tableview.getSelectionModel().getSelectedItem().getLibelle(),
                tableview.getSelectionModel().getSelectedItem().getNb_participant(),
                        tableview.getSelectionModel().getSelectedItem().getDescription(),
                                tableview.getSelectionModel().getSelectedItem().getPrix(),
                                            tableview.getSelectionModel().getSelectedItem().getDate_fin()
                
                    
                );
        FormationGestionController.connectedFormaion = c;
        
             Parent page1 = FXMLLoader.load(getClass().getResource("ModifierFormation.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();  
        
        
        
        
        
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
                Parent page1 = FXMLLoader.load(getClass().getResource("FormationAjout.fxml"));
        Scene scene = new Scene(page1);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void affichsalle(ActionEvent event) throws IOException {
         FormationService ps = new FormationService();
        
                Formation c =new Formation(
                        tableview.getSelectionModel().getSelectedItem().getId(),
                tableview.getSelectionModel().getSelectedItem().getLieu(),
                
                tableview.getSelectionModel().getSelectedItem().getDate_debut(),
                 tableview.getSelectionModel().getSelectedItem().getType_form(),
                tableview.getSelectionModel().getSelectedItem().getLibelle(),
                tableview.getSelectionModel().getSelectedItem().getNb_participant(),
                        tableview.getSelectionModel().getSelectedItem().getDescription(),
                                tableview.getSelectionModel().getSelectedItem().getPrix(),
                                            tableview.getSelectionModel().getSelectedItem().getDate_fin()
                             );
           
                
FormationGestionController.connectedFormaion2 = c;
             Parent page1 = FXMLLoader.load(getClass().getResource("AfficherDetailFormation.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();   
        
         
        
        
    }

    @FXML
    private void Retour(ActionEvent event) {
    }

    @FXML
    private void participant(ActionEvent event) throws IOException {
            Parent page1 = FXMLLoader.load(getClass().getResource("ParticipantGestion.fxml"));
        Scene scene = new Scene(page1);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }
    
}
