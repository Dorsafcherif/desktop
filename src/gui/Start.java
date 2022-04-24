/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author lenovo
 */
public class Start extends Application {
    
    @Override
    public void start(Stage primaryStage) { //stage: fenetre dont on va executer
        
	
		try {
			Parent root = FXMLLoader.load(getClass().getResource("DemandeFormateurBack.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
//        try {
//        
//        Parent root =FXMLLoader.load(getClass().getResource("DemandeFormateurFormulaire.fxml"));//load prend la  desination du fichier
//        Scene scene = new Scene(root, 300, 250); //scene: l'interface affiché actuellement ;root:sont les composants graphiques(ex:bouton) qui construisent la scene
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        } catch (IOException ex) {
// Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex); 
//        }
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
    
}
