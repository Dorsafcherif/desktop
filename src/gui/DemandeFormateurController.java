/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.DemandeFormateur;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import service.DemandeFormateurService;

/**
 *
 * @author lenovo
 */
public class DemandeFormateurController implements Initializable {
   
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tftelephone;
    @FXML
    private TextField  tfsexe;
    @FXML
    private DatePicker dpdate;
   @FXML
	public Button btn1;
  
	@FXML
	public ListView listview;
	Connection cnx;
        PreparedStatement pst;
	/**
	 * select single pdf file
	 */
	

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
      
        // TODO
    }    
            	FileChooser fc = new FileChooser();
                DemandeFormateur p =new DemandeFormateur();
    

@FXML
    void singlefile (ActionEvent event){

		//  connexion = MyDB.getInstance().getConnection();
       
        
       FileChooser fc = new FileChooser();
		// if we want to open fixed location
		//fc.setInitialDirectory(new File("D:\\\\Books"));
		
		// if we want to fixed file extension
		fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));
		File selectedFile = fc.showOpenDialog(null);
		
		if(selectedFile != null) {
			listview.getItems().add(selectedFile.getAbsolutePath());
		}else {
			System.out.println("File is not valid!");
		}
                 
             
                     
    }

    

    @FXML
    private void ajouterdemandeformateur(ActionEvent event) {

        
        
        DemandeFormateur p = new DemandeFormateur();
       // DemandeFormateurService ps = new DemandeFormateurService();
                DatePicker datePicker = new DatePicker();

        // if we want to open fixed location
        //fc.setInitialDirectory(new File("D:\\\\Books"));
	//if we want to fixed file extension
        //File dest = new File(C:\Users\lenovo\Documents\NetBeansProjects + "\\gui\\validation1.CV\\" + file.getName());

                       
         if (tfnom.getText().equals("")
                || tfprenom.getText().equals("")
                        || tfadresse.getText().equals("")
                        || tfsexe.getText().equals("") 
                        || tftelephone.getText().equals("")
                  //|| dpdate.getValue().equals(""))
                        || tfmail.getText().equals("")
                  || tfmail.getText().contains("@") 
                        || !tfmail.getText().contains(".") 
//                       || email.getText().indexOf("@", 0) > email.getText().indexOf(".", 0) 
                        || tfmail.getText().indexOf("#", 0) >= 0
                        || tfmail.getText().indexOf("&", 0) >= 0
                        || tfmail.getText().indexOf("(", 0) >= 0
//                        | email.getText().length() - email.getText().replace("@", "").length() > 1
//                        || email.getText().length() - email.getText().replace(".", "").length() > 1
                        || tfmail.getText().indexOf("Â§", 0) >= 0
                        || tfmail.getText().indexOf("!", 0) >= 0
                        || tfmail.getText().indexOf("Ã§", 0) >= 0
                        || tfmail.getText().indexOf("Ã ", 0) >= 0
                        || tfmail.getText().indexOf("Ã©", 0) >= 0
                        || tfmail.getText().indexOf(")", 0) >= 0
                        || tfmail.getText().indexOf("{", 0) >= 0
                        || tfmail.getText().indexOf("}", 0) >= 0
                        || tfmail.getText().indexOf("|", 0) >= 0
                        || tfmail.getText().indexOf("$", 0) >= 0
                        || tfmail.getText().indexOf("*", 0) >= 0
                        || tfmail.getText().indexOf("â‚¬", 0) >= 0
                        || tfmail.getText().indexOf("`", 0) >= 0
                        || tfmail.getText().indexOf("\'", 0) >= 0
                        || tfmail.getText().indexOf("\"", 0) >= 0
                        || tfmail.getText().indexOf("%", 0) >= 0
                        || tfmail.getText().indexOf("+", 0) >= 0
                        || tfmail.getText().indexOf("=", 0) >= 0
                        || tfmail.getText().indexOf("/", 0) >= 0
                        || tfmail.getText().indexOf("\\", 0) >= 0
                        || tfmail.getText().indexOf(":", 0) >= 0
                        || tfmail.getText().indexOf(",", 0) >= 0
                        || tfmail.getText().indexOf("?", 0) >= 0
                        || tfmail.getText().indexOf(";", 0) >= 0
                        || tfmail.getText().indexOf("Â°", 0) >= 0
                        || tfmail.getText().indexOf("<", 0) >= 0
                       )
              if (!(tftelephone.getText().matches("\\d{8}"))) {
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez selectionnez un numéro de telephone valide");
            alert.showAndWait();
            return;

     }
                 
//                
                // || cv.getText().equals(""))
             
                 
         {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Veuillez renseigner tous les champs! ");
            a.setHeaderText(null);
            a.showAndWait();
             
        }  
//         try {
//             class.forName("com.mysql.jdbc.Driver");
//             con = DriverManager.getConnection(url, user, password)
         
//         File dest = new File(projectPath + "\\src\\validation1.CV\\" + file.getName());
//
//        FileUtils.copyFile(file, dest);

        DemandeFormateurService ps = new DemandeFormateurService();
           
        p.setNom(tfnom.getText());
        p.setPrenom(tfprenom.getText());
        p.setMail(tfmail.getText());
        p.setAdresse(tfadresse.getText());
        p.setSexe(tfsexe.getText());
        p.setTelephone(Integer.parseInt(tftelephone.getText()));
//        p.setDatedenaissance((dpdate.getValue().toString()));
    //    p.setCv(listview.get());
        
        

        ps.ajouter(p);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setContentText("Demande ajoutée");
        alert.show();
    }
}
//     @FXML
//    private void ajoutdemande(ActionEvent event) throws IOException {
//        btncr.getScene().getWindow().hide();
//                Parent root = FXMLLoader.load(getClass().getResource("DemandeFormateurFormulaire.fxml"));
//                Stage mainStage = new Stage();
//                Scene scene = new Scene(root);
//                mainStage.setScene(scene);
//                mainStage.show();
//    }
//    
//     @FXML
//    private void ajoutCr(ActionEvent event) throws IOException {
//        btncr.getScene().getWindow().hide();
//                Parent root = FXMLLoader.load(getClass().getResource("DemandeFormateurFormulaire.fxml"));
//                Stage mainStage = new Stage();
//                Scene scene = new Scene(root);
//                mainStage.setScene(scene);
//                mainStage.show();
//    }
//    @FXML
//    private void AddFile(MouseEvent event) {
//        
//        Stage stage2 = null;
//
//                file = fileChooser.showOpenDialog(stage2);
//
//                cv.setText(file.getName());
//        
//    }
    
//   public void TitleValidator() {
//        RegexValidator valid = new RegexValidator();
//        valid.setRegexPattern("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z])$");
//        titletf.setValidators(valid);
//        valid.setMessage("Please enter a valid title");
//        titletf.focusedProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
//                System.out.println(oldPropertyValue + " " + newPropertyValue);
//                if (!newPropertyValue) {
//                    titletf.validate();
//                    if (titletf.validate()) {
//                        ValidTitle = true;
//                    } else {
//                        ValidTitle = false;
//                    }
//                }
//            }
//        
//            });
//}
//
//    public void VilleValidator() {
//        RegexValidator valid = new RegexValidator();
//        valid.setRegexPattern("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z])$");
//        villetf.setValidators(valid);
//        valid.setMessage("Please enter a valid Ville");
//        villetf.focusedProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
//                System.out.println(oldPropertyValue + " " + newPropertyValue);
//                if (!newPropertyValue) {
//                    villetf.validate();
//                    if (villetf.validate()) {
//                        ValidVille = true;
//                    } else {
//                        ValidVille = false;
//                    }
//                }
//            }
//        
//
//            });
//}
//    
//    
//    public void DomainValidator() {
//        RegexValidator valid = new RegexValidator();
//        valid.setRegexPattern("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z])$");
//        domaintf.setValidators(valid);
//        valid.setMessage("Please enter a valid Domain");
//        domaintf.focusedProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
//                System.out.println(oldPropertyValue + " " + newPropertyValue);
//                if (!newPropertyValue) {
//                    domaintf.validate();
//                    if (domaintf.validate()) {
//                        ValidDomain = true;
//                    } else {
//                        ValidDomain = false;
//                    }
//                }
//            }
//        
//
//            });
//}
//    
//    public void CompanyValidator() {
//        RegexValidator valid = new RegexValidator();
//        valid.setRegexPattern("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z])$");
//        cmpNametf.setValidators(valid);
//        valid.setMessage("Please enter a valid Ville");
//        cmpNametf.focusedProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
//                System.out.println(oldPropertyValue + " " + newPropertyValue);
//                if (!newPropertyValue) {
//                    cmpNametf.validate();
//                    if (cmpNametf.validate()) {
//                        ValidDesc = true;
//                    } else {
//                        ValidDesc = false;
//                    }
//                }
//            }
//        
//
//            
//        
//            });
//}
//    
//    public void TypeValidator() {
//        RegexValidator valid = new RegexValidator();
//        valid.setRegexPattern("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z])$");
//        typetf.setValidators(valid);
//        valid.setMessage("Please enter a valid Type");
//        typetf.focusedProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
//                System.out.println(oldPropertyValue + " " + newPropertyValue);
//                if (!newPropertyValue) {
//                    typetf.validate();
//                    if (typetf.validate()) {
//                        ValidType = true;
//                    } else {
//                        ValidType = false;
//                    }
//                }
//            }
//        
//
//            });
//}
//    
//    public void DescValidator() {
//        RegexValidator valid = new RegexValidator();
//        valid.setRegexPattern("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z])$");
//        desctf.setValidators(valid);
//        valid.setMessage("Please enter a valid Description");
//        desctf.focusedProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
//                System.out.println(oldPropertyValue + " " + newPropertyValue);
//                if (!newPropertyValue) {
//                    desctf.validate();
//                    if (desctf.validate()) {
//                        ValidType = true;
//                    } else {
//                        ValidType = false;
//                    }
//                }
//            }
//        
//
//            
//        
//            });
//}
//    
//    public void SalaryValidator() {
//        RegexValidator valid = new RegexValidator();
//        valid.setRegexPattern("^[0-9]+$");
//        saltf.setValidators(valid);
//        valid.setMessage("Please enter a valid Salary");
//        saltf.focusedProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
//                System.out.println(oldPropertyValue + " " + newPropertyValue);
//                if (!newPropertyValue) {
//                    saltf.validate();
//                    if (saltf.validate()) {
//                        ValidSalary = true;
//                    } else {
//                        ValidSalary = false;
//                    }
//                }
//            }
//        

//            });
//} 

