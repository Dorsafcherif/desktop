/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class AfficherOffreDetailController implements Initializable {

    @FXML
    private Label type;
    @FXML
    private Label entreprise;
    @FXML
    private Label position;
    @FXML
    private Label fonctionnalites;
    @FXML
    private Label description1;
    @FXML
    private Label date_exp;
    @FXML
    private Label updated_at;

 

  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         description1.setText(AfficherOffreFrontController.connectedOffre2.getDescription());
         
          entreprise.setText( AfficherOffreFrontController.connectedOffre2.getEntreprise());
                      
            position.setText( AfficherOffreFrontController.connectedOffre2.getPosition());
             fonctionnalites.setText( AfficherOffreFrontController.connectedOffre2.getFonctionnalites());
              
                            type.setText( AfficherOffreFrontController.connectedOffre2.getType());

        
         
 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
           String strDate = dateFormat.format(AfficherOffreFrontController.connectedOffre2.getDate_exp());  
           String strDate2 = dateFormat.format(AfficherOffreFrontController.connectedOffre2.getUpdated_at());    
            date_exp.setText(strDate);
            
            updated_at.setText(strDate);
        
        
        

        
        
    }    
    
}
