package gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.DemandeFormateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.DemandeFormateurService;


/**
 *
 * @author molka
 */
public class DemandeFormateurBackController implements Initializable {

    DemandeFormateurService Sp = new DemandeFormateurService();
    @FXML
    private Button retour;
    @FXML
    private TableView<DemandeFormateur> tblProd;
    @FXML
    private TableColumn<DemandeFormateur, String> tbNom;
    @FXML
    private TableColumn<DemandeFormateur, String> tbPrix;
    @FXML
    private TableColumn<DemandeFormateur, String> tbQuant;
    @FXML
    private TableColumn<DemandeFormateur, String> tbCat;


   
    @FXML
    private Button DelP;
   

    @FXML
    private ComboBox<String> combCat;

 

    ObservableList<DemandeFormateur> list;

    

  

   
    @FXML
    private TextField tfdescription;
    @FXML
    private TableColumn<DemandeFormateur, String> tbDes;
    
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableArrayList(Sp.GetAll());

        tbNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tbPrix.setCellValueFactory(new PropertyValueFactory<>("mail"));
        tbQuant.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        tbCat.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        tbDes.setCellValueFactory(new PropertyValueFactory<>("sexe"));

        tblProd.setItems(list);

        tblProd.setRowFactory(tv -> {

            TableRow<DemandeFormateur> row = new TableRow<>();



            return row;
        });

 
    }

    @FXML
    private void returnb(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DemandeFormateurFormulaire.fxml"));
            Parent root = loader.load();
            retour.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }



    @FXML
    private void DelP(ActionEvent event) {
        final DemandeFormateur selectedItem = tblProd.getSelectionModel().getSelectedItem();
        DemandeFormateur prod = Sp.GetById(selectedItem.getId());
        Sp.supprimer(prod.getId());

        list.remove(selectedItem);
        tblProd.setItems(FXCollections.observableArrayList(Sp.GetAll()));
        tblProd.refresh();
    }




    


}
