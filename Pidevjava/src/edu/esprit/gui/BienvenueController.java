/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class BienvenueController implements Initializable {
  private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    @FXML
    private MediaView VideoAcceuil;
    @FXML
    private Button pause;
    @FXML
    private Button reset;
    @FXML
    private Button play;
    @FXML
    private Button inscrivezvous;
    @FXML
    private Button seconnecter;

    /**
     * Initializes the controller class.
     */
   
   public void initialize(URL url, ResourceBundle rb) {
      // file = new File("C:\\Users\\ASUS\\Desktop\\emira\\Pidevjava\\src\\images\\pub.mp4");
      //  media = new Media(file.toURI().toString());
      //  mediaPlayer = new MediaPlayer(media);
      //  VideoAcceuil.setMediaPlayer(mediaPlayer);
       // mediaPlayer.play();
       
    }    

  /*  @FXML
    private void PauseMedia(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    private void ResetMedia(ActionEvent event) {

        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
        }
    }

    @FXML
    private void Playvideo(ActionEvent event) {
        mediaPlayer.play();
    }

    @FXML
    private void InscrivezVous(ActionEvent event) throws IOException {

    }*/


    @FXML
    private void Seconnecter(ActionEvent event) throws IOException {
//        mediaPlayer.pause();
        Parent page1 = FXMLLoader.load(getClass().getResource("FormationGestion.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Se Connecter");
        stage.setScene(scene);
        stage.show();
//      mediaPlayer.pause();
    }

 
    
}
