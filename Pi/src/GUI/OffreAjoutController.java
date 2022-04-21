/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.OffreService;
import entities.Offre;
import java.time.LocalDate;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class OffreAjoutController implements Initializable {
   Connection connexion;   
    @FXML
    private Button Timage;
    @FXML
    private ImageView imgajoutincours;
    @FXML
    private Label imgpathttt;
    @FXML
    private TextField Profil;
    private ToggleGroup zd_genre;
    @FXML
    private DatePicker date_exp;
    @FXML
    private TextField entreprise;
    @FXML
    private TextField position;
    @FXML
    private DatePicker updated_at;
    @FXML
    private TextField fonctionnalites;
    @FXML
    private ComboBox<String> Type;
  public OffreAjoutController() {
        connexion = MyDB.getInstance().getConnection();
    } 
    //@FXML
    //private Label welcome;
   /* @FXML
    private Button A;*/
   @FXML
    private TextField description;
   // private TextField Prix;
   @FXML
    private Hyperlink prec;
  //  private DatePicker DateEvent;*/
    @FXML
    private ComboBox<Integer> Categorie;

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           try {
            String req = "select * from categorie_emploi";
            Statement stm = connexion.createStatement();
            ResultSet rst = stm.executeQuery(req);
            
            while (rst.next()) {
             //   Users a = new Users(rst.getInt("id"));
                
                Integer xx = rst.getInt("id");
                Categorie.getItems().add(xx);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    Type.getItems().add("CDD");
                Type.getItems().add("CDI");
                 Type.getItems().add("Temps-partiel");
                 Type.getItems().add("Temps-plein");
                 Type.getItems().add("Alternance"); 
                 Type.getItems().add("Freelance"); 
                 
                

    }    
    
     public boolean validateInputs() {
     if (updated_at.getValue().isBefore(date_exp.getValue())){
           Alert alert2 = new Alert(Alert.AlertType.WARNING);
                alert2.setTitle("Erreur !");
                alert2.setContentText("Date Fin doit etre superieur au date debut !");
                alert2.setHeaderText(null);
                alert2.show();
                return false;
     }
     else if (updated_at.getValue().isAfter(LocalDate.now())) {
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
    private void insert(ActionEvent event) throws SQLException, IOException {
          OffreService productService = new OffreService();
        
        if (Profil.getText().equals("")
                || description.getText().equals("")
                || fonctionnalites.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Remplir les champs ");
            a.setHeaderText(null);
            a.showAndWait();
        
        }  
               
               
              else if (entreprise.getText().matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")
                || description.getText().equals("")
                || position.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText(" Le champs entreprise ne doit pas contenir le symbole : "+ entreprise.getText() );
            a.setHeaderText(null);
            a.showAndWait();
        }       
               
               
         
           java.util.Date date2
                = java.util.Date.from(this.date_exp.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                 java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
                 
                   java.util.Date date3
                = java.util.Date.from(this.updated_at.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                 java.sql.Date sqlDate3 = new java.sql.Date(date2.getTime());

              
        Offre c = new Offre(Categorie.getValue(),Timage.getText(),description.getText(),
                
               Type.getValue(),Profil.getText(),entreprise.getText(),   position.getText(),
                
                
                sqlDate2,  sqlDate3,fonctionnalites.getText());
              
           
        
        productService.ajouterOffre(c);
       
            
       
      Parent page1 = FXMLLoader.load(getClass().getResource("OffreGestion.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Liste des Offres");
        stage.setScene(scene);
        stage.show();
        
         
        
          }
        
         
        
     
   
@FXML
    private void addimgcours(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        File file = fileChooser.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            imgajoutincours.setImage(image);
            imgajoutincours.setFitWidth(200);
            imgajoutincours.setFitHeight(200);
            imgajoutincours.scaleXProperty();
            imgajoutincours.scaleYProperty();
            imgajoutincours.setSmooth(true);
            imgajoutincours.setCache(true);
            FileInputStream fin = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fin.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            byte[] person_image = bos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger("ss");
        }
        imgpathttt.setText(file.getAbsolutePath());
    }
    
    
    
    @FXML
    private void prec(ActionEvent event) throws IOException {
         Parent page1 = FXMLLoader.load(getClass().getResource("OffreGestion.fxml"));
        Scene scene = new Scene(page1);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


}
